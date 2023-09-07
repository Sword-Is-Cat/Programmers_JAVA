package level3.ex몸짱트레이너라이언의고민;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

	public int solution(int n, int m, int[][] timetable) {

		// 사람이 가장 몰리는 시간대의 사람수 구하기
		Arrays.sort(timetable, (a, b) -> a[0] - b[0]);
		PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> a - b);
		int users = 0;

		for (int[] time : timetable) {
			while (!que.isEmpty() && que.peek() < time[0]) {
				que.poll();
			}
			que.add(time[1]);
			users = Math.max(users, que.size());
		}

		// 안겹쳤으면 return 0
		if (users == 1)
			return 0;

		// 가능한 거리 head, 불가능한거리 tail로 초기화 후 이진탐색
		int head = 1, tail = 2 * n - 1;

		while (head + 1 < tail) {
			int mid = (head + tail) / 2;
			if (users <= countPossible(n, mid))
				head = mid;
			else
				tail = mid;
		}

		return head;
	}

	// distance거리로 users명 수용가능여부 확인
	int countPossible(int length, int distance) {

		ArrayList<boolean[]> firstRowList = new ArrayList<>();
		boolean[] array = new boolean[length];
		array[0] = true;
		getFirstRowsDfs(distance, distance, array, firstRowList);

		int count = 1;

		for (boolean[] firstRow : firstRowList) {
			count = Math.max(count, countMaximum(length, distance, firstRow));
		}

		return count;
	}

	void getFirstRowsDfs(int index, int dist, boolean[] array, ArrayList<boolean[]> container) {

		if (array.length <= index) {
			container.add(array.clone());
			return;
		}

		for (int i = index; i < array.length; i++) {
			array[i] = true;
			getFirstRowsDfs(i + dist, dist, array, container);
			array[i] = false;
		}

	}

	int countMaximum(int length, int distance, boolean[] firstRow) {

		int[][] grid = new int[length][length];
		int count = 0;

		for (int i = 0; i < length; i++) {
			if (firstRow[i]) {
				count++;
				visitCoord(grid, 0, i, distance);
			}
		}

		for (int row = 1; row < length; row++) {
			for (int col = 0; col < length; col++) {
				if (grid[row][col] == 0) {
					count++;
					visitCoord(grid, row, col, distance);
				}
			}
		}

		return count;
	}

	void visitCoord(int[][] grid, int row, int col, int dist) {

		if (row < 0 || col < 0 || row == grid.length || col == grid.length || dist <= grid[row][col])
			return;

		grid[row][col] = dist;

		visitCoord(grid, row, col - 1, dist - 1);
		visitCoord(grid, row, col + 1, dist - 1);
		visitCoord(grid, row + 1, col, dist - 1);

	}

}