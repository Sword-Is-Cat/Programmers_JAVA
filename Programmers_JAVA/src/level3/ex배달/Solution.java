package level3.ex배달;

class Solution {

	Integer[][] arr;
	int n;

	public int solution(int N, int[][] road, int K) {

		n = N;
		arr = new Integer[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i][i] = 0;
		}

		for (int[] way : road) {
			addway(way[0], way[1], way[2]);
		}

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			if (arr[1][i] <= K)
				answer++;
		}

		return answer;
	}

	public void addway(int a, int b, int distance) {

		if (arr[a][b] == null || arr[a][b] > distance) {
			arr[a][b] = distance;
			arr[b][a] = distance;

			for (int i = 1; i <= n; i++) {
				if (arr[b][i] != null)
					addway(a, i, distance + arr[b][i]);
				if (arr[a][i] != null)
					addway(b, i, distance + arr[a][i]);
			}
		}
	}
}