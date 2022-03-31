class Solution {
    public String restoreString(String s, int[] indices) {
    	String res = "";
    	char[] ca = s.toCharArray();
    	Map<Integer, Character> map = new TreeMap<Integer, Character>();
    	for(int i=0;i<indices.length;i++)
    		map.put(indices[i], ca[i]);
    	for(Map.Entry<Integer, Character> entry : map.entrySet())
    		res+=entry.getValue();
		return res;
    }
}