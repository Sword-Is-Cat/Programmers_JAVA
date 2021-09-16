package weekly._7th;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
	public int[] solution(int[] enter, int[] leave) {

		Queue<Integer> enterQ = new LinkedList<>();
		Queue<Integer> leaveQ = new LinkedList<>();

		for (int i = 0; i < enter.length; i++) {
			enterQ.add(enter[i]);
			leaveQ.add(leave[i]);
		}

		Set<Integer> room = new HashSet<>();
		int[] answer = new int[enter.length];

		while (!leaveQ.isEmpty()) {

			if (room.contains(leaveQ.peek())) {
				
				room.remove(leaveQ.poll());
				
			} else {
				
				answer[enterQ.peek() - 1] = room.size();

				for (int person : room) 
					answer[person - 1]++;

				room.add(enterQ.poll());
			}
		}
		return answer;
	}
}