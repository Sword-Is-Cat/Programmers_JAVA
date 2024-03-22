package level3.PCCP04;

class Solution {

	int rowMax, colMax, answer = Integer.MAX_VALUE;
	int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int solution(int[][] maze) {

		rowMax = maze.length;
		colMax = maze[0].length;

		boolean[][] redVst = new boolean[rowMax][colMax], blueVst = new boolean[rowMax][colMax];
		int redR = -1, redC = -1, blueR = -1, blueC = -1;

		for (int row = 0; row < rowMax; row++) {
			for (int col = 0; col < colMax; col++) {
				if (maze[row][col] == 1) {
					redR = row;
					redC = col;
				} else if (maze[row][col] == 2) {
					blueR = row;
					blueC = col;
				}
			}
		}

		dfs(maze, redVst, blueVst, new int[] { redR, redC }, new int[] { blueR, blueC }, 0);

		return answer == Integer.MAX_VALUE ? 0 : answer;
	}

	private void dfs(int[][] maze, boolean[][] redVst, boolean[][] blueVst, int[] red, int[] blue, int move) {

		if (isValid(maze, redVst, red[0], red[1], 3) && isValid(maze, blueVst, blue[0], blue[1], 4) && move < answer) {
			redVst[red[0]][red[1]] = true;
			blueVst[blue[0]][blue[1]] = true;

			if (maze[red[0]][red[1]] == 3 && maze[blue[0]][blue[1]] == 4) {
				// red, blue 모두 도착
				answer = Math.min(answer, move);
			} else if (maze[red[0]][red[1]] == 3) {
				// red만 도착
				for (int d = 0; d < dir.length; d++) {
					int[] newBlue = new int[] { blue[0] + dir[d][0], blue[1] + dir[d][1] };
					if (isSamePosition(red, newBlue)) // 충돌방지
						continue;
					dfs(maze, redVst, blueVst, red, newBlue, move + 1);
				}

			} else if (maze[blue[0]][blue[1]] == 4) {
				// blue만 도착
				for (int d = 0; d < dir.length; d++) {
					int[] newRed = new int[] { red[0] + dir[d][0], red[1] + dir[d][1] };
					if (isSamePosition(newRed, blue)) // 충돌방지
						continue;
					dfs(maze, redVst, blueVst, newRed, blue, move + 1);
				}

			} else {
				// 둘다 도착못함
				for (int rd = 0; rd < dir.length; rd++) {
					for (int bd = 0; bd < dir.length; bd++) {
						int[] newBlue = new int[] { blue[0] + dir[bd][0], blue[1] + dir[bd][1] };
						int[] newRed = new int[] { red[0] + dir[rd][0], red[1] + dir[rd][1] };
						if (isSamePosition(newRed, newBlue)
								|| (isSamePosition(red, newBlue) && isSamePosition(newRed, blue)))// 충돌
							continue;
						dfs(maze, redVst, blueVst, newRed, newBlue, move + 1);
					}
				}
			}

			redVst[red[0]][red[1]] = false;
			blueVst[blue[0]][blue[1]] = false;
		}

	}

	private boolean isValid(int[][] maze, boolean[][] visit, int row, int col, int fin) {
		return 0 <= row && 0 <= col && row < rowMax && col < colMax && maze[row][col] != 5
				&& (!visit[row][col] || maze[row][col] == fin);
	}

	private boolean isSamePosition(int[] coord1, int[] coord2) {
		return coord1[0] == coord2[0] && coord1[1] == coord2[1];
	}

}