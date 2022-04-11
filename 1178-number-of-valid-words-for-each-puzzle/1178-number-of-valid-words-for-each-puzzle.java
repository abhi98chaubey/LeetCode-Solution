class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) 
    {
        List<Integer> ans = new ArrayList<>();
    	HashMap<Integer,Integer> map = new HashMap<>();
			// creating the hashmap
    	for(int i=0;i<words.length;i++)
    	{
    		int wordmask = createMask(words[i]);
    		if(map.containsKey(wordmask))
    		{
    			int oldfreq = map.get(wordmask);
    			int newfreq = oldfreq+1;
    			map.put(wordmask,newfreq);
    		}
    		else
    		{
    			map.put(wordmask,1);
    		}
    	}
    	// finding count of valid words for all puzzles
    	for(int i=0;i<puzzles.length;i++)
    	{
    		int puzzlemask = createMask(puzzles[i]); //creating bit-mask of ith puzzle
    		//finding combinations of puzzlemask that match with a word
    		char firstChar = puzzles[i].charAt(0);
    		int first = 1 << (firstChar - 'a'); // first char mask
    		int sub = puzzlemask;
    		int count=0;
    		while(sub!=0)
    		{
    			boolean _1stCharPresent = ((sub & first)==first)?true:false;
    			boolean wordvalid = map.containsKey(sub); // when a combination of ith puzzle is present as word in the map
    			if(_1stCharPresent==true && wordvalid==true)
    				count += map.get(sub); // add freq of the word
    			
    			sub = (sub-1) & puzzlemask; //get to th next substring
    		}
    		ans.add(count);
    	}
    	return ans;
    }
    
	private  int createMask(String str)
	{
		int mask = 0;
		for(int i=0;i<str.length();i++)
		{
			int bit = str.charAt(i)-'a';
			mask = (mask | (1 << bit));
		}
		return mask;
	}
}