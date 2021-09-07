package level2.ex거리두기확인하기;

class Solution {
	public int[] solution(String[][] places) {

		int[] answer = new int[5];
		for (int i = 0; i < 5; i++) {

			answer[i] = checkDistance(places[i]);

		}

		return answer;
	}

	public int checkDistance(String[] place) {

		char[][] pla = new char[5][];

		for (int i = 0; i < 5; i++) {
			pla[i] = place[i].toCharArray();
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {

				if (i < 3 && checkRow(pla, i, j))
					return 0;

				if (j < 3 && checkCol(pla, i, j))
					return 0;

				if (i < 4 && j < 4 && checkBox(pla, i, j))
					return 0;

			}
		}
		return 1;
	}

	public boolean checkRow(char[][] pla, int i, int j) {

		if (pla[i][j] == 'P' && pla[i + 1][j] == 'P')
			return true;
		if (pla[i + 1][j] == 'P' && pla[i + 2][j] == 'P')
			return true;
		if (pla[i][j] == 'P' && pla[i + 1][j] == 'O' && pla[i + 2][j] == 'P')
			return true;

		return false;
	}

	public boolean checkCol(char[][] pla, int i, int j) {

		if (pla[i][j] == 'P' && pla[i][j + 1] == 'P')
			return true;
		if (pla[i][j + 1] == 'P' && pla[i][j + 2] == 'P')
			return true;
		if (pla[i][j] == 'P' && pla[i][j + 1] == 'O' && pla[i][j + 2] == 'P')
			return true;

		return false;
	}

	public boolean checkBox(char[][] pla, int i, int j) {

		int cntP = 0;
		int cntX = 0;
		int cntO = 0;

		for (int ii = 0; ii < 2; ii++) {
			for (int jj = 0; jj < 2; jj++) {
				char ch = pla[i + ii][j + jj];
				if (ch == 'P')
					cntP++;
				else if (ch == 'X')
					cntX++;
				else if (ch == 'O')
					cntO++;
			}
		}

		if (cntP == 2 && cntX < 2)
			return true;

		return false;
	}

}