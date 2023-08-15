package level2.ex혼자서하는틱택토;

class Solution {
	public int solution(String[] board) {

		char[][] grid = new char[3][];
		for (int i = 0; i < 3; i++)
			grid[i] = board[i].toCharArray();

		int cntO = 0, cntX = 0;
		boolean tttO = false, tttX = false;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i][j] == 'O')
					cntO++;
				else if (grid[i][j] == 'X')
					cntX++;
			}
		}

		if (grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2]) {
			if (grid[0][0] == 'O')
				tttO = true;
			else if (grid[0][0] == 'X')
				tttX = true;
		}

		if (grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2]) {
			if (grid[1][0] == 'O')
				tttO = true;
			else if (grid[1][0] == 'X')
				tttX = true;
		}

		if (grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2]) {
			if (grid[2][0] == 'O')
				tttO = true;
			else if (grid[2][0] == 'X')
				tttX = true;
		}

		if (grid[0][0] == grid[1][0] && grid[1][0] == grid[2][0]) {
			if (grid[0][0] == 'O')
				tttO = true;
			else if (grid[0][0] == 'X')
				tttX = true;
		}

		if (grid[0][1] == grid[1][1] && grid[1][1] == grid[2][1]) {
			if (grid[0][1] == 'O')
				tttO = true;
			else if (grid[0][1] == 'X')
				tttX = true;
		}

		if (grid[0][2] == grid[1][2] && grid[1][2] == grid[2][2]) {
			if (grid[0][2] == 'O')
				tttO = true;
			else if (grid[0][2] == 'X')
				tttX = true;
		}

		if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
			if (grid[0][0] == 'O')
				tttO = true;
			else if (grid[0][0] == 'X')
				tttX = true;
		}

		if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
			if (grid[0][2] == 'O')
				tttO = true;
			else if (grid[0][2] == 'X')
				tttX = true;
		}

		// 돌 수 자체가 맞지 않음
		if (cntO < cntX || cntO - cntX > 1)
			return 0;

		// 둘 다 이김
		if (tttO && tttX)
			return 0;
		
		// O가 이겼는데 돌 수가 같음
		if(tttO && cntO == cntX)
			return 0;
		
		// X가 이겼는데 돌 수가 다름
		if(tttX && cntO != cntX)
			return 0;

		return 1;
	}
}