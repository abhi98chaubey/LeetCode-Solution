class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            l.add(i);
        }

        int position = 0;
        while (l.size() > 1) {
            int next = (position + k - 1) % l.size();
            l.remove(next);
            position = next;
        }
        
        return l.get(0);
    }
}