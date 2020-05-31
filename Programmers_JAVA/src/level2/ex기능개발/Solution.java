package level2.ex기능개발;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {

		List<Integer> list = new ArrayList<>();
		boolean[] fin = new boolean[progresses.length];
		int time = 0;

		for (int i = 0; i < progresses.length; i++) {

			if (fin[i])
				continue;

			if (time * speeds[i] + progresses[i] < 100) {
				time++;
				i--;
				
			} else {

				fin[i] = true;
				int count = 1;

				for (int j = i + 1; j < progresses.length; j++) {

					if (!fin[j] && time * speeds[j] + progresses[j] >= 100) {
						
						fin[j] = true;
						count++;
					} else {
						
						break;
					}

				}

				list.add(count);
			}

		}

		int[] answer = new int[list.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

}