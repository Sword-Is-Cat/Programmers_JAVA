package level0.ex카운트업;

class Solution {
	public int[] solution(int start, int end) {
		return java.util.stream.IntStream.range(start, end + 1).toArray();
	}
}