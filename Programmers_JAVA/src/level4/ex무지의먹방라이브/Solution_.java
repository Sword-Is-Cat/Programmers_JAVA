package level4.ex무지의먹방라이브;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution_ {

	public int solution(int[] food_times, long k) {

		// 모든 음식을 다 먹을수 있는 경우
		long sum = 0;
		for (int foodTime : food_times)
			sum += foodTime;
		if (sum <= k)
			return -1;

		// 음식 섭취시간이 적은 순서대로 정렬될 PriorityQueue 선언 및 음식 정보 주입
		PriorityQueue<Food> queue = new PriorityQueue<>((a, b) -> a.fTimes - b.fTimes);
		for (int i = 0; i < food_times.length; i++) {
			queue.add(new Food(i, food_times[i]));
		}

		// 회전판이 돌아간 수 cycle, 경과한 시간 time
		int cycle = 0;
		long time = 0;

		while ((queue.peek().fTimes - cycle) * (long) queue.size() <= (k - time)) {
			int foodsCnt = queue.size();
			Food food = queue.poll();
			time += (food.fTimes - cycle) * (long) foodsCnt;
			cycle = food.fTimes;
		}

		ArrayList<Food> list = new ArrayList<>(queue);
		list.sort((a, b) -> a.index - b.index);

		long remain = k - time;
		int index = (int) (remain % list.size());

		return list.get(index).index + 1;
	}

	class Food {
		int index;
		int fTimes;

		public Food(int index, int fTimes) {
			this.index = index;
			this.fTimes = fTimes;
		}
	}
}