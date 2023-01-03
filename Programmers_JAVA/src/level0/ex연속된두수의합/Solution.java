package level0.ex연속된두수의합;

import java.util.stream.IntStream;

class Solution {
	public int[] solution(int num, int total) {
		int init = (total - (num * (num - 1) / 2)) / num;
		return IntStream.range(0, num).map(i -> i + init).toArray();
	}
}