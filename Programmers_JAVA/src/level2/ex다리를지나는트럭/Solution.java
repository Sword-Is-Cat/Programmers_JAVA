package level2.ex다리를지나는트럭;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {

		int second = 0;
		int sum = 0;
		Queue<Integer> bridge = new LinkedList<>();
		for (int i = 0; i < bridge_length; i++) {
			bridge.add(0);
		}
		
		int truck = next(truck_weights);
		
		do {
			sum -= bridge.poll();
			second++;
			if(sum+truck<=weight) {
				sum += truck;
				bridge.add(truck);
				truck = next(truck_weights);
			}else {
				bridge.add(0);
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