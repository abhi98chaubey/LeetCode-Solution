class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int i =0, j =height.length-1;
        while( i < j) {
            area = Math.max(area, Math.min(height[i], height[j])*(j-i));
            int temp = (height[i] < height[j]) ? ++i: --j;
        }
        return area;
    }
}