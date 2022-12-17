package level2.ex디펜스게임;

import java.util.PriorityQueue;

class Solution {
	public int solution(int n, int k, int[] enemy){
		// queue에 담긴 숫자는 무적권으로 방어할 라운드의 적의 수
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int round = 0; round < enemy.length; round++) {
			// 각 라운드의 적의 수를 queue에 담는다
			queue.add(enemy[round]);
			// 무적권의 수 보다 방어할 라운드가 많은 경우, 적의 수가 가장 적은 라운드 전투하여 병력감소
			if (queue.size() > k)
				n -= queue.poll();
			// 병력이 0보다 적어지면 게임이 종료되며 해당 라운드 수를 반환한다(라운드는 0-index 이므로 -1 하지 않아도 된다)
			if (n < 0)
				return round;
		}
		// 게임 클리어 한 경우, 총 라운드 수 반환
		return enemy.length;
	}
}