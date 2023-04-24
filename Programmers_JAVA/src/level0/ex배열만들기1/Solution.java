package level0.ex배열만들기1;

import java.util.stream.IntStream;

class Solution {
	public int[] solution(int n, int k) {
		return IntStream.range(0, n / k).map(i -> (i + 1) * k).toArray();
	}
}