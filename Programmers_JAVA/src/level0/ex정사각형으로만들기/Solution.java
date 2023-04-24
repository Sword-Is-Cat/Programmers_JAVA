package level0.ex정사각형으로만들기;

class Solution {
	public int[][] solution(int[][] arr) {

		int length = Math.max(arr.length, arr[0].length);
		int[][] answer = new int[length][length];

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {

				if (i < arr.length && j < arr[i].length)
					answer[i][j] = arr[i][j];
				else
					answer[i][j] = 0;

			}
		}

		return answer;
	}
}