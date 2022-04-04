class TrieNode {
	public TrieNode[] children = new TrieNode[2];
}

class Solution {
	TrieNode root = new TrieNode();

	public int findMaximumXOR(int[] nums) {
		for(int num: nums) {
			insert(num);
		}

		int ans = 0;
		for(int num: nums) {
			ans = Math.max(ans, maxXor(num));
		}
		return ans;
	}

	public int maxXor(int n) {
		int ans = 0;
		TrieNode current = this.root;

		for(int i = 31; i >= 0 && current != null; i--) {
			int curBit = ((n & (1 << i)) == 0) ? 0 : 1;
			int reqBit = 1 - curBit;

			if(current.children[reqBit] != null) {
				ans = ans * 2 + 1;
				current = current.children[reqBit];
			}
			else {
				ans = ans * 2;
				current = current.children[curBit];
			}
		}
		return ans;
	}

	public void insert(int n) {
		TrieNode current = this.root;

		for(int i = 31; i >= 0; i--) {
			int curBit = ((n & (1 << i)) == 0) ? 0 : 1;

			if(current.children[curBit] == null) {
				current.children[curBit] = new TrieNode();
			}
			current = current.children[curBit];
		}
	}
}