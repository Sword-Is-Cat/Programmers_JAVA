package level0.ex직사각형넓이구하기;

class Solution {
	public int solution(int[][] dots) {

		int minX = 1000, maxX = -1000, minY = 1000, maxY = -1000;

		for (int[] dot : dots) {
			minX = Math.min(minX, dot[0]);
			maxX = Math.max(maxX, dot[0]);
			minY = Math.min(minY, dot[1]);
			maxY = Math.max(maxY, dot[1]);
		}

		return (maxX - minX) * (maxY - minY);
	}
}