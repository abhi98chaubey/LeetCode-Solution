class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int[] temp = new int[nums.length];

        for (int i : nums) {
            temp[i - 1]++;
        }

        for (int i = 0; i < nums.length; i++) {
            if(temp[i] == 0){
                ans.add(i+1);
            }
        }

        return ans;
    }
}