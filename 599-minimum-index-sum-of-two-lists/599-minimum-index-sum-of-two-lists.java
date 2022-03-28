class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
       // Keep track of each element's index
        HashMap<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        // stores min sum of index for each common Restaurant
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int index = i + map.get(list2[i]);
                // if index < min then this is the new answer
                if (index < min) {
                    min = index;
                    ans.clear();
                    ans.add(list2[i]);
                    // if equal index then this must be added to the same ans arr
                } else if (index == min)
                    ans.add(list2[i]);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}