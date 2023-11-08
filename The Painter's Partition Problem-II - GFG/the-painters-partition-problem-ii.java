//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
    static long minTime(int[] nums,int n,int k){
        //code here
         long lo=Integer.MIN_VALUE;
        for(int num:nums){
            lo=Math.max(num,lo);

        }
        long hi=0;
        for(int num:nums){
            hi=hi+num;
            
        }
        while(lo<hi){
            long mid = lo+(hi-lo)/2;
            long sumallowed=mid;
            long req=1;
            long sum=0;
            for(int num:nums){
                if(sum+num<=sumallowed){
                    sum+=num;
                }else{
                    req++;
                    sum=num;
                }
            }
            if(req<=k){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }
}


