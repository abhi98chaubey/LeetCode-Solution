class Solution {
  public int findMinArrowShots(int[][] points) {
         
        Arrays.sort(points, (a,b) -> Integer.compare(a[1],b[1]));
        
        int minArr = 1;// Start with 1 arrow
        int lastArrowPos = points[0][1]; // Keep the arrow at end of first interval
        
        // Now check if the next intervals are under the lastArrow position ?
        for(int i=1;i<points.length;i++) {
            if(points[i][0] > lastArrowPos) {// next interval(start) is beyond the curr arrow position, so we need another arrow. And update arrow position to current end
                lastArrowPos = points[i][1];
                minArr++;
            }
        }
        return minArr;
    }
}