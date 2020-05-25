package level3.ex네트워크;

class Solution {

	int[][] computers;
	int[] arr;
	int n;

	public int solution(int n, int[][] computers) {

		this.computers = computers;
		this.arr = new int[n];
		this.n = n;
		int answer = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				arr[i] = ++answer;
				process(i);
			}
		}

		return answer;
	}

	public void process(int i) {

		for (int j = 0; j < n; j++) {
			if (computers[i][j] == 1 && arr[j] == 0) {
				arr[j] = arr[i];
				process(j);
			}
		}

	}
}