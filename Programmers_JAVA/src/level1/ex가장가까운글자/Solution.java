package level1.ex가장가까운글자;

import java.util.Arrays;

class Solution {
	public int[] solution(String s) {

		char[] array = s.toCharArray();
		int[] indexs = new int[26];
		Arrays.fill(indexs, -1);
		int[] answer = new int[array.length];

		for (int idx = 0; idx < array.length; idx++) {

			char ch = array[idx];
			int chInt = (int) (ch - 'a');
			answer[idx] = indexs[chInt] == -1 ? -1 : idx - indexs[chInt];
			indexs[chInt] = idx;

		}

		return answer;
	}
}