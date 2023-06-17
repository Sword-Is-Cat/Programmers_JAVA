package level2.ex리코쳇로봇;

import java.util.ArrayList;

class Solution {

	// 4방향 이동용 direct
	int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	char[][] grid;

	public int solution(String[] board) {

		// board를 charArray로 변환 및 같은 크기의 visit
		grid = new char[board.length][];
		for (int idx = 0; idx < board.length; idx++)
			grid[idx] = board[idx].toCharArray();

		boolean[][] visit = new boolean[grid.length][grid[0].length];

		// 로봇의 초기위치 row/col 및 목표지점의 gRow/gCol 찾기
		int row = -1, col = -1, gRow = -1, gCol = -1;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 'R') {
					row = i;
					col = j;
				} else if (grid[i][j] == 'G') {
					gRow = i;
					gCol = j;
				}
			}
		}

		// bfs용 변수 선언 및 초기화
		ArrayList<int[]> prev, curr = new ArrayList<>();
		visit[row][col] = true;
		curr.add(new int[] { row, col });
		int move = 0;

		// bfs 실행
		while (!visit[gRow][gCol] && !curr.isEmpty()) {
			prev = curr;
			curr = new ArrayList<>();
			for (int[] coord : prev) {
				for (int d = 0; d < 4; d++) {
					int[] newCoord = ricochetMove(coord, d);
					if (!visit[newCoord[0]][newCoord[1]]) {
						visit[newCoord[0]][newCoord[1]] = true;
						curr.add(newCoord);
					}
				}
			}
			move++;
		}
		
		// 목표점에 도달여부에 따라 return값 결정
		return visit[gRow][gCol] ? move : -1;
	}

	// 좌표와 방향을 통해 ricochet이동 시행
	protected int[] ricochetMove(int[] coord, int d) {
		int row = coord[0], col = coord[1];
		int nRow = row + direct[d][0], nCol = col + direct[d][1];
		while (0 <= nRow && 0 <= nCol && nRow < grid.length && nCol < grid[nRow].length && grid[nRow][nCol] != 'D') {
			row = nRow;
			col = nCol;
			nRow = row + direct[d][0];
			nCol = col + direct[d][1];
		}
		return new int[] { row, col };
	}
}