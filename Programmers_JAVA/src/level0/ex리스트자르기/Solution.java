package level0.ex리스트자르기;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
	public int[] solution(int n, int[] slicer, int[] num_list) {

		int[] answer = null;
		int a = slicer[0], b = slicer[1], c = slicer[2];

		switch (n) {
		case 1:
			answer = Arrays.copyOf(num_list, b + 1);
			break;
		case 2:
			answer = Arrays.copyOfRange(num_list, a, num_list.length);
			break;
		case 3:
			answer = Arrays.copyOfRange(num_list, a, b + 1);
			break;
		case 4:
			answer = IntStream.range(0, (b - a) / c + 1).map(i -> num_list[a + i * c]).toArray();
			break;
		}

		return answer;
	}
}