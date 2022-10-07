package level0.ex삼각형의완성조건;

import java.util.Arrays;

class Solution {
	public int solution(int[] sides) {

		Arrays.sort(sides);

		return sides[0] + sides[1] > sides[2] ? 1 : 2;
	}
}