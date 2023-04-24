package level0.ex수열과구간쿼리1;

class Solution {
	public int[] solution(int[] arr, int[][] queries) {

		for (int[] query : queries) {
			int s = query[0], e = query[1];
			for (int i = s; i <= e; i++)
				arr[i]++;
		}
		return arr;
	}
}