package level0.ex삼각형의완성조건2;

class Solution {
	public int solution(int[] sides) {

		return Math.min(sides[0], sides[1]) * 2 - 1;
	}
}