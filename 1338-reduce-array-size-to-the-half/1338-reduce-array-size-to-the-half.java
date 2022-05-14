class Solution {
    public int minSetSize(int[] arr) {
        
    Map<Integer,Integer> map = new HashMap<>();
    for(int i:arr){
        map.put(i,map.getOrDefault(i,0)+1);
    }
    List<Integer> list = new ArrayList<>(map.values());
    Collections.sort(list,Collections.reverseOrder());
    int target= arr.length/2;
    int sum=0;
    for(int i=0;i<list.size();i++){
        sum+=list.get(i);
        if(sum>=target){
            return i+1;
        }
    }
    return -1;

    }
}