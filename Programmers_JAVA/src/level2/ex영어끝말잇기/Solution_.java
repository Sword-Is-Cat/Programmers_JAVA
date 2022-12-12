package level2.ex영어끝말잇기;

import java.util.HashSet;

class Solution_ {
	public int[] solution(int n, String[] words) {

		int idx = 0;
		char lastChar = ' ';
		HashSet<String> duplCheck = new HashSet<>();

		while (idx < words.length) {

			String word = words[idx];
			if (!duplCheck.add(word))
				break;

			if (lastChar != word.charAt(0) && lastChar != ' ')
				break;

			lastChar = word.charAt(word.length() - 1);
			idx++;

		}

		return idx == words.length ? new int[] { 0, 0 } : new int[] { idx % n + 1, idx / n + 1 };
	}
}