class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        
        for(int i = 1; i <= 9; i++) {
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(i);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(i, 1);
        build(n-i, 1, k, map, list, i);
        
        }
        return retlist;
        
    }
    
    List<List<Integer>> retlist = new ArrayList<List<Integer>>();
    
    HashMap<String, Integer> glomap = new HashMap<String, Integer>();
    
    public void build(int rem_sum, int count, int k, HashMap<Integer, Integer> map, LinkedList<Integer> list, int index) {
        
        if(count > k) return;
        if (rem_sum < 0) return;
        
        if((rem_sum == 0) && (count == k)) {
            List<Integer> temp = new ArrayList<>(list);
            Collections.sort(temp);
            StringBuilder s = new StringBuilder();
            for(Integer entry : temp) {
               s.append(entry + "#");
            }
            if(glomap.get(s.toString()) != null) return;
            glomap.put(s.toString(),1);
            retlist.add(temp);
            return;
        }
        
        for(int i = index+1; i < 10; i++) {
            
            if(i > rem_sum) break;
            if(map.get(i) != null) continue;
            map.put(i, 1);
            list.add(i);
            build(rem_sum-i, count + 1, k, map, list, index);
            list.removeLast();
            map.remove(i);
        }  
        
    }    
}