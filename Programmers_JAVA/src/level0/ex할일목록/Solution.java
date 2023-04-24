package level0.ex할일목록;

import java.util.stream.IntStream;

class Solution {
	public String[] solution(String[] todo_list, boolean[] finished) {
		return IntStream.range(0, finished.length).filter(i -> !finished[i]).mapToObj(i -> todo_list[i])
				.toArray(String[]::new);
	}
}