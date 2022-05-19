class Solution {
    public int countArrangement(int n) {
        
        build(n, 0, new int[n]);
        return gcount; 
    }
    
    int gcount = 0;
    
    public void build(int n, int count, int[] visited) {
        
        if(count == n) {
         //   System.out.println("true");
            gcount++;
            return;
        }
        
        for(int i = 1; i <= n ; i++) {
            
           if(visited[i-1] == 1) continue;
            int num = i;
            count = count + 1;
            if (((num % count) == 0) || ((count % num) == 0)) { 
            //    System.out.println(num);
                visited[i-1] = 1;
                build(n, count, visited);
                visited[i-1] = 0;
            }
            count = count - 1;
        }   
    }
    
}