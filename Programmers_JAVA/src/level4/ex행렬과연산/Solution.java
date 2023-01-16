package level4.ex행렬과연산;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public int[][] solution(int[][] rc, String[] operations) {

		Deque<Integer> leftLine = new ArrayDeque<>();
		Deque<Integer> rightLine = new ArrayDeque<>();
		Deque<Deque<Integer>> grid = new ArrayDeque<>();

		int rowMax = rc.length - 1, colMax = rc[0].length - 1;

		for (int row = 0; row <= rowMax; row++) {
			Deque<Integer> que = new ArrayDeque<>();
			grid.addLast(que);
			for (int col = 0; col <= colMax; col++) {
				int value = rc[row][col];
				if (col == 0)
					leftLine.add(value);
				else if (col == colMax)
					rightLine.add(value);
				else
					que.add(value);
			}
		}

		for (String operation : operations) {
			switch (operation.charAt(0)) {
			case 'S':
				leftLine.addFirst(leftLine.pollLast());
				rightLine.addFirst(rightLine.pollLast());
				grid.addFirst(grid.pollLast());
				break;
			case 'R':
				grid.getFirst().addFirst(leftLine.pollFirst());
				rightLine.addFirst(grid.getFirst().pollLast());
				grid.getLast().addLast(rightLine.pollLast());
				leftLine.addLast(grid.getLast().pollFirst());
				break;
			}
		}

		int row = 0, col = 0;

		while (!leftLine.isEmpty() && !rightLine.isEmpty() && !grid.isEmpty()) {

			col = 0;

			rc[row][col++] = leftLine.pollFirst();
			Deque<Integer> que = grid.pollFirst();
			while (!que.isEmpty()) {
				rc[row][col++] = que.pollFirst();
			}
			rc[row][col++] = rightLine.pollFirst();

			row++;

		}
		return rc;
	}
}