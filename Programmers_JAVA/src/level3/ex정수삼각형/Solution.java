package level3.ex정수삼각형;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/43105
 */

class Solution {
	public int solution(int[][] triangle) {

		for (int i = triangle.length - 2; i >= 0; i--) {
			for (int j = 0; j < triangle[i].length; j++) {
				triangle[i][j] += triangle[i + 1][j] > triangle[i + 1][j + 1] ? triangle[i + 1][j] : triangle[i + 1][j + 1];
			}
		}
		return triangle[0][0];
	}
}