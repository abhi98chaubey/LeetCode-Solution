class Solution {
	public int mostWordsFound(String[] sentences) {
		int res=0;

		for(String sen:sentences){
			int curr=0;
			for(char ch:sen.toCharArray())
				if(ch==' ')
					curr++;
			res=Math.max(curr+1,res);
		}

		return res;
	}
}