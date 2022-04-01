class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(Collections.reverseOrder());

        for(int x: stones)
            priorityQueue.add(x);

        while(priorityQueue.size()>1){
            int y=priorityQueue.remove();
            int x=priorityQueue.remove();

            if(x!=y)
                priorityQueue.add(y-x);
        }
        if(priorityQueue.isEmpty())
            return 0;
        else
            return priorityQueue.remove();
        
    }
}