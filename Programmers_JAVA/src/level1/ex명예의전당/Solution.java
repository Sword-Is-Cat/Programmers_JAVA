package level1.ex명예의전당;

import java.util.PriorityQueue;

class Solution {
	public int[] solution(int k, int[] score) {
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for (int i = 0; i < score.length; i++) {
			que.add(score[i]);
			while (que.size() > k) {
				que.poll();
			}
			score[i] = que.peek();
		}
		return score;
	}
}