class Solution {
   public int maximumSwap(int num) {
        List<Integer> res = new ArrayList<>();
        while(num > 0) {
            res.add(num % 10);
            num /= 10;
        }
        outer:
        for(int i = res.size() - 1; i >= 0; i--){
            if(res.get(i) < 9) {
                int max = Integer.MIN_VALUE;
                int swapIdx = 0;
                int idx = i - 1;
                while(idx >= 0) {
                    if (res.get(idx) > res.get(i) && res.get(idx) >= max) {
                        max = res.get(idx);
                        swapIdx = idx;
                    }
                    idx--;
                }
                if(max != Integer.MIN_VALUE) {
                    int tmp = res.get(swapIdx);
                    res.set(swapIdx, res.get(i));
                    res.set(i, tmp);
                    break outer;
                }
            }
        }
        int ans = 0;
        for(int i = res.size() - 1; i >= 0; i--){
            ans *= 10;
            ans += res.get(i);
        }
        return ans;
    }
}