package level0.ex특이한정렬;

import java.util.PriorityQueue;

class Solution {
	public int[] solution(int[] numlist, int n) {

		PriorityQueue<Integer> que = new PriorityQueue<>(
				(a, b) -> Math.abs(a - n) == Math.abs(b - n) ? b - a : Math.abs(a - n) - Math.abs(b - n));

		for (int num : numlist)
			que.add(num);

		int idx = 0;

		while (!que.isEmpty())
			numlist[idx++] = que.poll();

		return numlist;
	}
}