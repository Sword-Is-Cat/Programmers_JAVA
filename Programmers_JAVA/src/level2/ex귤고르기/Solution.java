package level2.ex귤고르기;

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
	public int solution(int k, int[] tangerine) {

		HashMap<Integer, Integer> counter = new HashMap<>();

		for (int weight : tangerine) {
			if (!counter.containsKey(weight))
				counter.put(weight, 0);
			counter.put(weight, counter.get(weight) + 1);
		}

		PriorityQueue<Integer> weights = new PriorityQueue<>((a, b) -> b - a);

		for (int key : counter.keySet())
			weights.add(counter.get(key));

		int cnt = 0, ans = 0;

		while (cnt < k) {
			cnt += weights.poll();
			ans++;
		}

		return ans;
	}
}