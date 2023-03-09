package level1.ex대충만든자판;

class Solution {
	public int[] solution(String[] keymap, String[] targets) {

		int[] keyInput = new int[26];
		char A = 'A';

		for (String key : keymap) {
			char[] arr = key.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				char ch = arr[i];
				int idx = ch - A;
				keyInput[idx] = keyInput[idx] == 0 ? i + 1 : Math.min(keyInput[idx], i + 1);
			}
		}

		int[] answer = new int[targets.length];

		for (int i = 0; i < targets.length; i++) {

			String target = targets[i];

			for (char ch : target.toCharArray()) {
				int inputs = keyInput[ch - A];
				if (inputs == 0) {
					answer[i] = -1;
					break;
				} else {
					answer[i] += keyInput[ch - A];
				}
			}
		}
		return answer;
	}
}