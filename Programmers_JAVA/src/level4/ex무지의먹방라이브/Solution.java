package level4.ex무지의먹방라이브;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
	public int solution(int[] food_times, long k) {

		PriorityQueue<int[]> foods = new PriorityQueue<int[]>((a, b) -> (a[1] - b[1]));

		for (int i = 0; i < food_times.length; i++) {
			int[] food = { i, food_times[i] };
			foods.add(food);
		}

		int last = 0;
		while (!foods.isEmpty() && k - ((long) foods.peek()[1] - last) * foods.size() >= 0) {
			int temp = foods.size();
			int[] food = foods.poll();
			k -= (long) temp * (food[1] - last);
			last = food[1];
		}

		if (foods.isEmpty())
			return -1;

		List<int[]> list = new ArrayList<>(foods);
		list.sort((a, b) -> (a[0] - b[0]));

		k = k % list.size();

		return list.get((int) k)[0] + 1;
	}
}