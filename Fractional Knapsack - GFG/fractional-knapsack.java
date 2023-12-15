//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends

//import java.math.BigDecimal;
/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
         Arrays.sort(arr, (a, b) -> (b.value * a.weight) - (a.value * b.weight));
        // Your code here
        // Arrays.sort(arr,(a,b)->(a.value/a.weight) - (b.value/b.weight));
        //Arrays.sort(arr, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
       
        double re=0.0;
        
        for(int i =0;i<n;i++){
            if(W>0 && W>=arr[i].weight){
                re+= arr[i].value;
                W=W-arr[i].weight;
            }else if (W>0 && W<arr[i].weight){
                re+= (arr[i].value/(double)arr[i].weight)*W;
                W=0;
            }
        }
        
        return re;
    }
}


//import java.math.BigDecimal;
//import java.util.Arrays;



// class Solution {
//     // Function to get the maximum total value in the knapsack.
//     double fractionalKnapsack(int W, Item arr[], int n) {
//         Arrays.sort(arr, (a, b) -> (b.value * a.weight) - (a.value * b.weight));

//         double result = 0.0;

//         for (int i = 0; i < n; i++) {
//             if (W > 0 && W >= arr[i].weight) {
//                 result += arr[i].value;
//                 W -= arr[i].weight;
//             } else if (W > 0 && W < arr[i].weight) {
//                 result += (arr[i].value / (double) arr[i].weight) * W;
//                 W = 0;
//             }
//         }

//         return result;
//     }
// }
