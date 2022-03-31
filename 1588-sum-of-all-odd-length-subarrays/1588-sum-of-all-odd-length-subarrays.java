class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
            for(int j = 0; j <= i; j++)
                if((i - j + 1) % 2 != 0) { // check if the current window has odd length
                    int idx = j;
                    while(idx <= i) sum += arr[idx++]; // loop through the current window and add to sum
                }
        return sum;
    }
}