package level2.ex다리를지나는트럭;
/*
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */

import java.util.ArrayDeque;

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {

		int second = 0;
		int sum = 0;
		ArrayDeque<Integer> bridge = new ArrayDeque<>();
		for (int i = 0; i < bridge_length; i++) {
			bridge.push(0);
		}
		
		int truck = next(truck_weights);
		
		do {
			sum -= bridge.pollLast();
			second++;
			if(sum+truck<=weight) {
				sum += truck;
				bridge.push(truck);
				truck = next(truck_weights);
			}else {
				bridge.push(0);
			}
		} while (sum > 0);

		return second;
	}

	public int next(int[] truck_weights) {

		int answer = 0;
		for (int i = 0; i < truck_weights.length; i++) {
			if (truck_weights[i] != 0) {
				answer = truck_weights[i];
				truck_weights[i] = 0;
				break;
			}
		}
		return answer;
	}
}