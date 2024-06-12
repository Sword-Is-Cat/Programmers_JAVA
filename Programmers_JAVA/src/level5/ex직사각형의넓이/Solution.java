package level5.ex직사각형의넓이;

import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
	public long solution(int[][] rectangles) {

		int length = rectangles.length;

		int[] yValue = new int[length * 2];
		int[][] queries = new int[length * 2][];

		for (int i = 0; i < length; i++) {

			yValue[i] = rectangles[i][1];
			yValue[i + length] = rectangles[i][3];

			queries[i] = new int[] { rectangles[i][0], 1, rectangles[i][1], rectangles[i][3] };
			queries[i + length] = new int[] { rectangles[i][2], -1, rectangles[i][1], rectangles[i][3] };

		}

		Arrays.sort(yValue);
		ArrayDeque<SegNode> que = new ArrayDeque<>();

		for (int i = 0; i < yValue.length - 1; i++) {
			if (yValue[i] < yValue[i + 1]) {
				que.add(new SegNode(yValue[i], yValue[i + 1]));
			}
		}

		while (que.size() > 1) {
			int loop = que.size();
			while (loop > 1) {
				que.add(new SegNode(que.poll(), que.poll()));
				loop -= 2;
			}
			if (loop == 1)
				que.add(que.poll());
		}
		SegNode root = que.poll();

		Arrays.sort(queries, (a, b) -> a[0] - b[0]);
		long prev = queries[0][0];
		long answer = 0;

		for (int[] query : queries) {
			answer += (query[0] - prev) * root.covered;
			prev = query[0];
			root.update(query[1], query[2], query[3]);
		}

		return answer;
	}
}

class SegNode {

	int min, max, mid;
	int depth, covered;
	SegNode left, right;

	public SegNode(int min, int max) {
		this.min = min;
		this.max = max;
		this.mid = 0;
		this.depth = 0;
		this.covered = 0;
		this.left = null;
		this.right = null;
	}

	public SegNode(SegNode left, SegNode right) {
		this(left.min, right.max);
		this.mid = left.max;
		this.left = left;
		this.right = right;
	}

	public void update(int change, int leftVal, int rightVal) {

		if (min == leftVal && max == rightVal) {
			depth += change;
		} else if (rightVal <= mid) {
			left.update(change, leftVal, rightVal);
		} else if (mid <= leftVal) {
			right.update(change, leftVal, rightVal);
		} else {
			left.update(change, leftVal, mid);
			right.update(change, mid, rightVal);
		}

		if (depth > 0) {
			covered = max - min;
		} else if (left != null && right != null) {
			covered = left.covered + right.covered;
		} else {
			covered = 0;
		}

	}

}