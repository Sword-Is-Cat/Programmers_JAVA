package level3.exN1카드게임;

import java.util.PriorityQueue;

class Solution {

	int n;
	int[] indexInfo;

	public int solution(int coin, int[] cards) {

		n = cards.length;
		indexInfo = new int[n + 1];
		indexInfo[0] = -1;

		for (int idx = 0; idx < n; idx++) {
			int value = cards[idx];
			indexInfo[value] = idx;
		}

		PriorityQueue<int[]> stack = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		PriorityQueue<int[]> hand = new PriorityQueue<>((a, b) -> a[1] - b[1]);

		for (int i = 1; i <= n / 2; i++)
			stack.add(calcPairInfo(i));

		int round = 1, index = n / 3;

		while (coin >= 0 && !stack.isEmpty()) {

			index += 2;

			while (!stack.isEmpty() && stack.peek()[0] < index)
				hand.add(stack.poll());

			if (!hand.isEmpty() && hand.peek()[1] <= coin) {
				coin -= hand.poll()[1];
			} else {
				return round;
			}
			round++;

		}

		return round;
	}

	private int[] calcPairInfo(int value) {

		int[] ans = new int[2];
		int value2 = n + 1 - value;

		ans[0] = Math.max(indexInfo[value], indexInfo[value2]);

		if (indexInfo[value] >= n / 3)
			ans[1]++;
		if (indexInfo[value2] >= n / 3)
			ans[1]++;

		return ans;
	}

}