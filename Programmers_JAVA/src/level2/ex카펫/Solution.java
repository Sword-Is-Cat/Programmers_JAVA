package level2.ex카펫;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 */

class Solution {
	public int[] solution(int brown, int yellow) {
		for (int y_height = 1; y_height < brown /4; y_height++) {
			int y_width = brown / 2 - 2 - y_height;
			if (y_height * y_width == yellow) {
				return new int[]{ yellow / y_height + 2, y_height + 2 };
			}
		}
		return null;
	}
}