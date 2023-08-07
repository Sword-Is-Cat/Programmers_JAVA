package level2.ex줄서는방법;

import java.util.ArrayList;

class Solution {

	int[] answer;
	long[] facto;
	ArrayList<Integer> list = new ArrayList<>();

	public int[] solution(int n, long k) {

		answer = new int[n];
		facto = new long[n + 1];
		facto[0] = 1;
		for (int i = 1; i <= n; i++) {
			list.add(i);
			facto[i] = facto[i - 1] * i;
		}

		query(0, k - 1);

		return answer;
	}

	public void query(int index, long k) {
		if (index < answer.length) {
			answer[index] = list.remove((int) (k / facto[answer.length - index - 1]));
			query(index + 1, k % facto[answer.length - index - 1]);
		}
	}

}