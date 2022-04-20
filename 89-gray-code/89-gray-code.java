class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> out = new ArrayList<>();
        int size = (int)Math.pow(2, n);
        for(int i = 0; i < size; i ++) {
            out.add(binaryToGray(i));
        }
        return out;
    }
    
    int binaryToGray(int n) {
        return n ^ (n >> 1);
    }
}