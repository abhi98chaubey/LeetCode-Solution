class Solution {
   public static boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < sLen; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            char ch = entry.getKey();
            int cnt = entry.getValue();
            if (!tMap.containsKey(ch) || (cnt != tMap.get(ch))) {
                return false;
            }
        }

        return true;
    }
}