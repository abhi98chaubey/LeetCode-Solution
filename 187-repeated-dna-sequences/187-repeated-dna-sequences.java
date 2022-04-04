class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        //To keep record of sequence already seen
        Set<String> seenSequence = new HashSet<>();
        //To store valid sequence and avoid duplicates
        Set<String> res = new HashSet<>();
        int sLength = s.length();
        
        for(int i=0;i<=sLength-10; i++){
            String sequence = s.substring(i,i+10);
            //add function does not add ele already in set and returns false
            if(!seenSequence.add(sequence)) res.add(sequence);  
        }
        
        return new ArrayList<>(res);
    }
}