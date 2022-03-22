class Solution {
    public List<String> cellsInRange(String s) {
        
     List<String> list = new ArrayList<String>();
        
     
     int k = (int)s.charAt(0);
     int l = (int)s.charAt(3); 
     int p = (int)s.charAt(4); 
     int m = (int)s.charAt(1);   
        
        
     for(int i = k ; i <= l ; i++)
     {
         for(int j = m ; j <= p ; j++ )
             
         {
           
           char b = (char)i;
           String s1 = Character.toString(j);
           s1 = b + s1;      
           list.add(s1);  
             
             
         }
         
         
         
     }
        
        
        
        return list;
        
        
    }
}