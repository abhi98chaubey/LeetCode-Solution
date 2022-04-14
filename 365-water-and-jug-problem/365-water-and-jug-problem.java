class Solution {
     public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
         
         Set<Integer> visited = new HashSet<>();
         
         return can(jug1Capacity,jug2Capacity,0,targetCapacity,visited) ;
         
        }

      public boolean can(int j1, int j2,int c, int tc,Set<Integer> v){
          
          
          if(c < 0 || c > j1+j2){
              return false;
          }
          
          if(c == tc){
             return true;
         } 
          
          if(!v.contains(c)){
            
          
           v.add(c);

            if(can(j1,j2,c + j1,tc,v) ||
             can(j1,j2,c - j1,tc,v) ||
             
             can(j1,j2,c + j2,tc,v) ||
             can(j1,j2,c - j2,tc,v) ){
              return true;
          } 
       
          }
            
             
            return false;
              
              
          }

   

    }