class Solution {
public int[] countPoints(int[][] points, int[][] queries) {
int rowC = queries.length;
int[] arr = new int[rowC];
int rowP = points.length;
for(int i = 0 ; i < rowC ; i++){
int count = 0;
int radius = queries[i][2];
radius = (int)Math.pow(radius , 2);
for(int j = 0 ; j < rowP ; j++){
int x = points[j][0];
int y = points[j][1];
int sum = (int)Math.pow(x-queries[i][0],2) + (int)Math.pow(y-queries[i][1],2);
if(sum <= radius)
count++;
}
arr[i] = count;
}
return arr;
}
}