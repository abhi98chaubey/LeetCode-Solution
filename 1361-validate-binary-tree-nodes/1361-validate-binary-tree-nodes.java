class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDeg = new int[n];
        
        for(int i = 0; i < n; i++){
            if(leftChild[i] != -1){
                inDeg[leftChild[i]]++;
                if(inDeg[leftChild[i]] > 1) return false;
                
            }
            
            if(rightChild[i] != -1){
                inDeg[rightChild[i]]++;
                if(inDeg[rightChild[i]] > 1) return false;
            }
            
        }
        
        boolean[] visited = new boolean[n];
        
        int root = -1;
        int roots = 0;
        
        for(int i = 0; i < n ; i++){
            if(inDeg[i] == 0){
                root = i;
                roots++;
            }
            
            if(roots > 1) return false;
        }
        
        if(roots != 1 || root == -1) return false;
        
        if(!topSort(root, inDeg, leftChild, rightChild, visited)) return false;
        
        for(boolean x : visited){
            if(!x) return false;
        }
        
        return true;
    }
    
    public boolean topSort(int src, int[] inDeg, int[] leftChild, int[] rightChild, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(src);
        
        visited[src] = true;
        
        while(q.size() > 0){
            
            src = q.remove();
            if(leftChild[src] != -1){
                
                if(visited[leftChild[src]]) return false;
                inDeg[leftChild[src]]--;
                if(inDeg[leftChild[src]] == 0) q.add(leftChild[src]);
                visited[leftChild[src]] = true;
            }

            if(rightChild[src] != -1){
                if(visited[rightChild[src]]) return false;
                inDeg[rightChild[src]]--;
                if(inDeg[rightChild[src]] == 0) q.add(rightChild[src]);
                visited[rightChild[src]] = true;
            }
        }
        
        return true;
        
    }
    
}