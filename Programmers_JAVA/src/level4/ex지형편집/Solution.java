package level4.ex지형편집;

import java.util.PriorityQueue;

public class Solution {
	public long solution(int[][] land, int P, int Q) {// 추가비용P, 제거비용Q

		/**
		 * tiles: 바닥의 총 칸수 total: 쌓여있는 블록의 총 수
		 */
		PriorityQueue<Integer> que = new PriorityQueue<>();
		int tiles = land.length * land[0].length;
		long total = 0;

		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				total += land[i][j];
				que.add(land[i][j]);
			}
		}

		/**
		 * val: 블럭 수를 낮은 값부터 iterate. 매 회차의 맞출 높이를 이 값으로 계산
		 * upperCnt: 기준값보다 높은 값들의 수
		 * upperStand: 기준값보다 높은 값들을 제거했을때 제거 후 블럭의 총 수
		 * upperSum: 기준값보다 높은 값들의 합
		 * lowerCnt:
		 * lowerStand:
		 * lowerSum: upper와 동일
		 */
		long answer = Long.MAX_VALUE;
		long lowerSum = 0;

		while (!que.isEmpty()) {

			int val = que.poll();
			lowerSum += val;

			int upperCnt = que.size();
			int lowerCnt = tiles - upperCnt;

			long upperSum = total - lowerSum;

			long upperStand = (long) val * upperCnt;
			long lowerStand = (long) val * lowerCnt;

			long cost = (lowerStand - lowerSum) * P + (upperSum - upperStand) * Q;
			answer = Math.min(answer, cost);

		}

		return answer;
	}
}