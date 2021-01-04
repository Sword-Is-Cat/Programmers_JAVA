package level1.ex3진법뒤집기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int n) {

		int answer = 0;

		Queue<Integer> queue = new LinkedList<Integer>();

		while (n > 0) {
			queue.add(n % 3);
			n = n / 3;
		}
		
		while(!queue.isEmpty()) {
			answer *= 3;
			answer += queue.poll();
		}

		return answer;
	}
}