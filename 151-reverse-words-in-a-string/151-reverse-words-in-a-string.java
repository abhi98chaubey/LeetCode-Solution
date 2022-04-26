class Solution {
    public String reverseWords(String s) {
         String str=s.replaceAll("\\s+"," ").trim();
    //trim it and remove extra space from middle keeping only one
    
    String [] ans=str.split("\\s"); //put it in an array 
    int l=ans.length;
    
   StringBuilder sr=new StringBuilder(); 
    
    for(int i=l-1;i>=0;i--)
    {
        sr.append(ans[i]).append(" ");
    }
    sr.deleteCharAt(sr.length()-1); //delete the last empty space
    
    return sr.toString();
    
    }
}