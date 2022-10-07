package level0.ex평행;

class Solution {
	public int solution(int[][] dots) {

		int[] dot1 = dots[0], dot2 = dots[1], dot3 = dots[2], dot4 = dots[3];

		boolean result = false;

		result |= checkParallel(dot1, dot2, dot3, dot4);
		result |= checkParallel(dot1, dot3, dot2, dot4);
		result |= checkParallel(dot1, dot4, dot3, dot2);

		return result ? 1 : 0;
	}

	boolean checkParallel(int[] a1, int[] a2, int[] b1, int[] b2) {

		int leftTop = a1[0] - a2[0];
		int leftBot = a1[1] - a2[1];
		int rightTop = b1[0] - b2[0];
		int rightBot = b1[1] - b2[1];

		return leftTop * rightBot == leftBot * rightTop;
	}
}