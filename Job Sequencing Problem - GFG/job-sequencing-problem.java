//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends

// class Solution
// {
//     //Function to find the maximum profit and the number of jobs done.
//     int[] JobScheduling(Job arr[], int n)
//     {
//         // Your code here
//         HashMap <Integer, Integer>map = new HashMap<>();
        
//         for(int i=0;i<arr.length;i++){
//             if(map.containsKey(arr[i].deadline)){
//                 if(map.getOrDefault(arr[i].deadline,0) <arr[i].profit ){
//                     map.getOrDefault(arr[i].deadline,0).put(arr[i].profit);
//                 }
//             }else{
//                 map.put(arr[i].deadline,arr[i].profit);
//             }
//         }
//         int ans=0;
//         int count=0;
//         for (Map.Entry<String, String> set :map.entrySet()){
//             ans+= set.getValue();
//             count++;
//         }
//         int an= {count,ans};
//         return an;
//     }
// }

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/



//import java.util.*;

// class Solution {
//     // Function to find the maximum profit and the number of jobs done.
//     int[] JobScheduling(Job arr[], int n) {
//         // Your code here
//         HashMap<Integer, Integer> map = new HashMap<>();

//         for (int i = 0; i < arr.length; i++) {
//             if (map.containsKey(arr[i].deadline)) {
//                 if (map.get(arr[i].deadline) < arr[i].profit) {
//                     map.put(arr[i].deadline, arr[i].profit);
//                 }
//             } else {
//                 map.put(arr[i].deadline, arr[i].profit);
//             }
//         }
//         int ans = 0;
//         int count = 0;
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             ans += entry.getValue();
//             count++;
//         }
//         int[] result = {count, ans};
//         return result;
//     }
// }



//import java.util.*;

// class solution {
//     int deadline, profit;

//     Job(int deadline, int profit) {
//         this.deadline = deadline;
//         this.profit = profit;
//     }
// }

class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Sort jobs in decreasing order of profit.
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        // Find the maximum deadline to create an array to store the scheduled jobs.
        int maxDeadline = 0;
        for (Job job : arr) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        int[] result = new int[2];
        int[] slots = new int[maxDeadline + 1];

        // Iterate through each job and schedule it if possible.
        for (Job job : arr) {
            for (int i = job.deadline; i > 0; i--) {
                if (slots[i] == 0) {
                    slots[i] = 1; // Mark slot as occupied.
                    result[0]++; // Increment count of scheduled jobs.
                    result[1] += job.profit; // Add profit of the scheduled job.
                    break;
                }
            }
        }

        return result;
    }
}





