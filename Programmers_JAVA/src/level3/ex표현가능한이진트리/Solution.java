package level3.ex표현가능한이진트리;

import java.util.Arrays;

class Solution {
	public int[] solution(long[] numbers) {

		return Arrays.stream(numbers)
				.mapToInt(i -> checkBiStr(toBiStr(i))).toArray();
	}

	int checkBiStr(String str) {

		if (str.replaceAll("0", "").length() == 0 || str.length() == 1)
			return 1;

		int mid = str.length() / 2;

		if (str.charAt(mid) == '0') {
			return 0;
		} else {
			return checkBiStr(str.substring(0, mid)) 
					* checkBiStr(str.substring(mid + 1));
		}

	}

	String toBiStr(long num) {
		StringBuilder sb = new StringBuilder();
		String biStr = Long.toBinaryString(num);
		int maxLength = 1;
		while (maxLength <= biStr.length()) {
			maxLength *= 2;
		}
		maxLength--;
		while (sb.length() + biStr.length() < maxLength)
			sb.append('0');
		sb.append(biStr);
		return sb.toString();
	}
}