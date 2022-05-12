class Solution {
    public void backtrack (int idx,int[] nums,List<Integer> ls,List<List<Integer>> ans, HashMap<Integer,Integer> fmap ){
        if (ls.size() ==nums.length){
            ans.add(new ArrayList<>(ls));
            return ;
        }
        for (int i : fmap.keySet()){
            if (fmap.get(i)>0){
                fmap.put(i,fmap.get(i)-1);
                ls.add(i);
                backtrack(idx,nums,ls,ans,fmap);
                ls.remove(ls.size()-1);
                fmap.put(i,fmap.get(i)+1);
            }
        }
        return ;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(nums);
        HashMap<Integer ,Integer> fmap = new HashMap<>();
        for (int i : nums){
            if (fmap.containsKey(i)){
                fmap.put(i,fmap.get(i)+1);
            }else{
                fmap.put(i,1);
            }
        }
        boolean[] br= new boolean[nums.length];
        backtrack(0,nums,ls,ans,fmap);
        return ans;
    }
}