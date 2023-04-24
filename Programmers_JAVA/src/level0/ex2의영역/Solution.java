package level0.ex2의영역;

import java.util.Arrays;

class Solution {
	public int[] solution(int[] arr) {

		int left = arr.length, right = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 2) {
				left = Math.min(left, i);
				right = Math.max(right, i);
			}
		}
		return right == -1 ? new int[] { -1 } : Arrays.copyOfRange(arr, left, right + 1);
	}
}