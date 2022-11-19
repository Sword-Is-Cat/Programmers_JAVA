package level2.ex혼자놀기의달인;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
	public int solution(int[] cards) {

		PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());
		boolean[] visit = new boolean[cards.length];

		for (int idx = 0; idx < cards.length; idx++)
			que.add(process(visit, cards, idx, 0));

		return que.size() < 2 ? 0 : que.poll() * que.poll();
	}

	int process(boolean[] visit, int[] cards, int idx, int value) {

		if (visit[idx])
			return value;
		else {

			visit[idx] = true;
			return process(visit, cards, cards[idx] - 1, value + 1);

		}

	}
}