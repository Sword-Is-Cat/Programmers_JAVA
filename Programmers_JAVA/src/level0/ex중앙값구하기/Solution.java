package level0.ex중앙값구하기;

import java.util.Arrays;

class Solution {
	public int solution(int[] array) {
		Arrays.sort(array);
		return array[array.length / 2];
	}
}