class FreqStack {

    private Queue<int[]> queue;
    private Map<Integer, Integer> map;
    private int index;
    
    public FreqStack() {
        index = 0;
        queue = new PriorityQueue<>((i, j) -> j[1] == i[1] ? j[2] - i[2] : j[1] - i[1]);
        map = new HashMap<>();
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        queue.offer(new int[]{val, map.get(val), index});
        index++;
    }
    
    public int pop() {
        int[] top = queue.poll();
        map.put(top[0], top[1] - 1);
        return top[0];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */