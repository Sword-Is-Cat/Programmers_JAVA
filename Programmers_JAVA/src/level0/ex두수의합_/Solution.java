package level0.ex두수의합_;

import java.util.Arrays;

class Solution {
	public String solution(String a, String b) {

		int length = Math.max(a.length(), b.length()) + 1;

		char[] arr = new char[length];
		Arrays.fill(arr, '0');

		char[] ar = a.toCharArray(), br = b.toCharArray();

		for (int i = 0; i < ar.length; i++) {
			arr[length - 1 - i] += ar[ar.length - 1 - i] - '0';
		}

		for (int i = 0; i < br.length; i++) {
			arr[length - 1 - i] += br[br.length - 1 - i] - '0';
		}

		for (int i = length - 1; i > 0; i--) {
			if (arr[i] > '9') {
				arr[i - 1] += 1;
				arr[i] -= 10;
			}
		}

		String answer = new String(arr);
		if (arr[0] == '0')
			answer = answer.substring(1);
		return answer;
	}
}