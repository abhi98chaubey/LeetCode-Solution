class Solution {
    public String arrangeWords(String text) {
        HashMap<Integer, List<String>> table = new HashMap<Integer, List<String>>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        String[] tokens = text.split(" ");
        for (int i = 0; i < tokens.length; i ++) {
            int key = tokens[i].length();
            if (table.containsKey(key)) {
                table.get(key).add(tokens[i]);
            } else {
                List<String> newList = new ArrayList<String>();
                newList.add(tokens[i]);
                table.put(key, newList);
                pq.offer(key);
            }
        }
        StringBuilder sb =new StringBuilder();
        while (!pq.isEmpty()) {
            List<String> strs = table.get(pq.poll());
            for (int i = 0; i < strs.size(); i ++) {
                sb.append(strs.get(i).toLowerCase() + " ");
            }
        }
        
        return ("" + sb.charAt(0)).toUpperCase() + sb.substring(1, sb.length() - 1).toString();
    }
}