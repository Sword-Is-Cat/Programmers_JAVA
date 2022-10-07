package level0.ex약수구하기;

import java.util.PriorityQueue;

class Solution {
	public int[] solution(int n) {

		PriorityQueue<Integer> que = new PriorityQueue<>();

		for (int div = 1; div * div <= n; div++) {

			if (n % div == 0) {

				que.add(div);
				if (n / div != div)
					que.add(n / div);

			}

		}

		int[] answer = new int[que.size()];

		int idx = 0;

		while (!que.isEmpty())
			answer[idx++] = que.poll();

		return answer;
	}
}