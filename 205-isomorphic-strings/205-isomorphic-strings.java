class Solution {
    public boolean isIsomorphic(String s, String t) {
      
List sIndex = new ArrayList();
List tIndex = new ArrayList();

    for(int i=0; i<s.length(); i++)
    {
        sIndex.add(s.indexOf(s.charAt(i)));
    }
    for(int j =0; j< t.length();j++)
    {
        tIndex.add(t.indexOf(t.charAt(j)));
    }
    
    
    return sIndex.equals(tIndex);
} 
    }
