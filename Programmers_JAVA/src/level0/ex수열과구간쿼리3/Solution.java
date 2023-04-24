package level0.ex수열과구간쿼리3;

class Solution {
	public int[] solution(int[] arr, int[][] queries) {

		for (int[] query : queries) {
			int i = query[0], j = query[1];
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}

		return arr;
	}
}