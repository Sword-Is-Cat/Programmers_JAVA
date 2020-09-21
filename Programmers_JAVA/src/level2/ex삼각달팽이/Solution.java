package level2.ex삼각달팽이;

class Solution {
	public int[] solution(int n) {

		int[][] arr = new int[n][];

		for (int i = 0; i < n; i++)
			arr[i] = new int[i + 1];

		int full = n * (n + 1) / 2;
		int no = 1;
		int i = 0, j = 0;

		while (i < n && j >= 0 && i >= j && arr[i][j] == 0) {

			while (i < n && j >= 0 && i >= j && arr[i][j] == 0)
				arr[i++][j] = no++;
			i--;
			j++;

			while (i < n && j >= 0 && i >= j && arr[i][j] == 0)
				arr[i][j++] = no++;
			i--;
			j -= 2;

			while (i < n && j >= 0 && i >= j && arr[i][j] == 0)
				arr[i--][j--] = no++;
			i += 2;
			j++;

		}

		int[] answer = new int[full];

		int index = 0;
		for (int[] ar : arr) {
			for (int a : ar) {
				answer[index++] = a;
			}
		}

		return answer;
	}
}