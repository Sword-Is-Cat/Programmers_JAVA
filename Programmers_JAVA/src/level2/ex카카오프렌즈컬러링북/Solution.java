package level2.ex카카오프렌즈컬러링북;

class Solution {
	public int[] solution(int m, int n, int[][] picture) {

		boolean[][] visit = new boolean[m][n];
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int result = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] != 0 && !visit[i][j]) {
					numberOfArea++;
					result = checkArea(m, n, picture, visit, i, j, picture[i][j]);
					maxSizeOfOneArea = (maxSizeOfOneArea > result) ? maxSizeOfOneArea : result;
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	public int checkArea(int m, int n, int[][] picture, boolean[][] visit, int i, int j, int value) {

		int result = 0;

		if (picture[i][j] == value && !visit[i][j]) {
			result += 1;
			visit[i][j] = true;
			if (i > 0)
				result += checkArea(m, n, picture, visit, i - 1, j, value);
			if (i + 1 < m)
				result += checkArea(m, n, picture, visit, i + 1, j, value);
			if (j > 0)
				result += checkArea(m, n, picture, visit, i, j - 1, value);
			if (j + 1 < n)
				result += checkArea(m, n, picture, visit, i, j + 1, value);
		}
		return result;
	}
}