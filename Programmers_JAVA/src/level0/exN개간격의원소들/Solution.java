package level0.exN개간격의원소들;

import java.util.stream.IntStream;

class Solution {
	public int[] solution(int[] num_list, int n) {
		return IntStream.range(0, (num_list.length - 1) / n + 1).map(i -> num_list[i * n]).toArray();
	}
}