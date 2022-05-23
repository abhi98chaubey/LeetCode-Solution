class Solution {
	public String getHint(String secret, String guess) {
		int bull = 0;
		int cows = 0;

		HashMap<Character, Integer> secretCnt = new HashMap<>();
		ArrayList<Character> guessCollector = new ArrayList<>();

		for(int i=0; i<secret.length(); ++i) {
			if(secret.charAt(i) == guess.charAt(i)) {
				bull++; 
			} else {
				// If it is not bull, add that in the secretCnt hashMap
				// and add to that the guess collector
				secretCnt.put(secret.charAt(i), secretCnt.getOrDefault(secret.charAt(i), 0) + 1);
				guessCollector.add(guess.charAt(i));
			}
		}

		// Iterate thorough the guess numbers that are not bull.
		for(char ch: guessCollector) {
			if(secretCnt.containsKey(ch)) {
				cows++;
				secretCnt.put(ch, secretCnt.get(ch)-1);

				if(secretCnt.get(ch) == 0) {
					secretCnt.remove(ch);
				}
			}
		}

		return bull+"A"+cows+"B";
	}
}