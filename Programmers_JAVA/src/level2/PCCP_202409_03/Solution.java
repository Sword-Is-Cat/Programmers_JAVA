package level2.PCCP_202409_03;

import java.util.HashSet;

class Solution {
	public int solution(int[][] points, int[][] routes) {

		Robot[] robots = new Robot[routes.length];
		for (int i = 0; i < routes.length; i++) {
			robots[i] = new Robot(points, routes[i]);
		}
		int crash = countCrash(robots);

		while (!isComplete(robots)) {
			for (Robot robot : robots)
				robot.move();
			crash += countCrash(robots);
		}

		return crash;
	}

	private boolean isComplete(Robot[] robots) {
		boolean result = true;
		for (Robot robot : robots)
			result &= robot.isEnd();
		return result;
	}

	private int countCrash(Robot[] robots) {
		HashSet<Integer> set = new HashSet<>(), dupl = new HashSet<>();
		for (Robot robot : robots) {
			if (!robot.isEnd()) {
				if (!set.add(robot.currentPosition())) {
					dupl.add(robot.currentPosition());
				}
			}
		}
		return dupl.size();
	}
}

class Robot {

	int row, col;
	int task;
	int[][] route;

	Robot(int[][] points, int[] route) {
		this.route = new int[route.length][];
		for (int i = 0; i < this.route.length; i++) {
			this.route[i] = points[route[i] - 1];
		}
		this.row = this.route[0][0];
		this.col = this.route[0][1];
		this.task = 0;
	}

	protected boolean isEnd() {
		return task == route.length;
	}

	protected void move() {
		if (!isEnd()) {
			if (route[task][0] == row && route[task][1] == col) {
				if (++task == route.length)
					return;
			}
			if (route[task][0] == row) {
				if (route[task][1] < col)
					col--;
				else
					col++;
			} else {
				if (route[task][0] < row)
					row--;
				else
					row++;
			}
		}
	}

	protected int currentPosition() {
		return row * 1000 + col;
	}

}