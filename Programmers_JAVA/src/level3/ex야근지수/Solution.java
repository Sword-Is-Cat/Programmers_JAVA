package level3.ex야근지수;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
	public long solution(int n, int[] works) {

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for (int work : works)
			queue.add(work);

		while (!queue.isEmpty() && n-- > 0)
			queue.add(queue.poll() - 1);

		long answer = 0L;

		while (!queue.isEmpty())
			answer += Math.pow(Math.max(0, queue.poll()), 2);

		return answer;
	}
}