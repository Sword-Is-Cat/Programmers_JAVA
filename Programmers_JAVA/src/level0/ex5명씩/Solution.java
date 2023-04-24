package level0.ex5명씩;

import java.util.stream.IntStream;

class Solution {
	public String[] solution(String[] names) {
		return IntStream.range(0, (names.length - 1) / 5 + 1).mapToObj(i -> names[i * 5].toString())
				.toArray(String[]::new);
	}
}