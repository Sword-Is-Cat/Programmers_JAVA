package level1.ex당구연습;

class Solution {
	public int[] solution(int m, int n, int startX, int startY, int[][] balls) {

		int[][] mirror = new int[4][];

		mirror[0] = new int[] { -startX, startY };
		mirror[1] = new int[] { startX, -startY };
		mirror[2] = new int[] { 2 * m - startX, startY };
		mirror[3] = new int[] { startX, 2 * n - startY };

		int[] answer = new int[balls.length], myball = { startX, startY };

		for (int i = 0; i < answer.length; i++) {
			answer[i] = process(myball, mirror, balls[i]);
		}

		return answer;
	}

	protected int process(int[] myball, int[][] mirror, int[] target) {

		int rst = Integer.MAX_VALUE;

		if (myball[1] != target[1] || myball[0] <= target[0])
			rst = Math.min(rst, distance(mirror[0], target));

		if (myball[0] != target[0] || myball[1] <= target[1])
			rst = Math.min(rst, distance(mirror[1], target));

		if (myball[1] != target[1] || myball[0] >= target[0])
			rst = Math.min(rst, distance(mirror[2], target));

		if (myball[0] != target[0] || myball[1] >= target[1])
			rst = Math.min(rst, distance(mirror[3], target));

		return rst;
	}

	protected int distance(int[] ball1, int[] ball2) {
		return (int) Math.pow(ball2[0] - ball1[0], 2) + (int) Math.pow(ball2[1] - ball1[1], 2);
	}
}