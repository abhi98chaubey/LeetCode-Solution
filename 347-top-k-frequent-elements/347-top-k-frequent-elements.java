class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        } 
        
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return map.get(b) - map.get(a);
            }
        });
        
        for(int num : map.keySet()) {
            maxHeap.offer(num);
        }
        
        int[] result = new int[k];
        int index = 0;
        while(index < k) {
            result[index++] = maxHeap.poll();
        }
        return result;
    }
}