package level0.ex배열비교하기;

import java.util.Arrays;

class Solution {
	public int solution(int[] arr1, int[] arr2) {
		int answer = Integer.compare(arr1.length, arr2.length);
		if (answer == 0)
			answer = Integer.compare(Arrays.stream(arr1).sum(), Arrays.stream(arr2).sum());
		return answer;
	}
}