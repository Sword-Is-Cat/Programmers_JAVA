package level0.ex배열조각하기;

import java.util.Arrays;

class Solution {
	public int[] solution(int[] arr, int[] query) {

		int left = 0, right = arr.length;

		for (int i = 0; i < query.length; i++) {
			if (i % 2 == 0) {
				// even
				right = left + query[i];
			} else {
				// odd
				left += query[i];
			}
		}

		return left < right ? Arrays.copyOfRange(arr, left, right) : new int[] { -1 };
	}
}