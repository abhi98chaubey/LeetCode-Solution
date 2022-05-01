class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        
        for (int[] pre: prerequisites) {
            // 0th index -> crs and 1st index -> pre
            preMap.get(pre[0]).add(pre[1]);
        }
        
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(preMap, visited, i)) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean dfs(Map<Integer, List<Integer>> preMap, Set<Integer> visited, int crs) {
        if (visited.contains(crs)) {
            return false;
        }
        if (preMap.get(crs).isEmpty()) {
            return true;
        }
        visited.add(crs);
        List<Integer> preReqs = preMap.get(crs);
        for (int pre : preReqs) {
            if(!dfs(preMap, visited, pre)) {
                return false;
            }
        }
        visited.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;
    }
}