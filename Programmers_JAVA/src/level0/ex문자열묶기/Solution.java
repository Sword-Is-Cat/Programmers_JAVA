package level0.ex문자열묶기;

import java.util.Arrays;

class Solution {
	public int solution(String[] strArr) {

		int[] counter = new int[31];

		for (String str : strArr) {
			counter[str.length()]++;
		}

		return Arrays.stream(counter).max().getAsInt();
	}
}