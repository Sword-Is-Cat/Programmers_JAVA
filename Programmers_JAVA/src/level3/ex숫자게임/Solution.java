package level3.ex숫자게임;

import java.util.Arrays;

class Solution {
	public int solution(int[] A, int[] B) {
		int i = 0;
		int j = 0;

		Arrays.sort(A);
		Arrays.sort(B);

		while (j < B.length) {
			if (A[i] >= B[j]) {
				j++;
			} else {
				i++;
				j++;
			}
		}

		return i;
	}
}