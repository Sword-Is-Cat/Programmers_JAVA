package level0.ex수열과구간쿼리4;

class Solution {
	public int[] solution(int[] arr, int[][] queries) {

		for (int[] query : queries) {
			int s = query[0], e = query[1], k = query[2];
			for(int i = s ; i<=e ; i++) {
				if(i%k==0)
					arr[i]++;
			}
		}

		return arr;
	}
}