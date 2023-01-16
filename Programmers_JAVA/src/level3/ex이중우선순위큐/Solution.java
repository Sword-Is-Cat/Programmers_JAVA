package level3.ex이중우선순위큐;

import java.util.PriorityQueue;

class Solution {
	public int[] solution(String[] operations) {

		PriorityQueue<Integer> ascQue = new PriorityQueue<>((a, b) -> a - b);
		PriorityQueue<Integer> descQue = new PriorityQueue<>((a, b) -> b - a);

		int cnt = 0;

		for (int i = 0; i < operations.length; i++) {

			String[] order = operations[i].split(" ");

			if (order[0].equals("I")) {
				int temp = Integer.parseInt(order[1]);
				ascQue.add(temp);
				descQue.add(temp);
				cnt++;
				//System.out.println("insert " + temp);
			} else if (order[0].equals("D")) {

				if (cnt == 0)
					continue;

				int temp = 0;

				if (order[1].equals("1")) {
					temp = descQue.poll();
				} else if (order[1].equals("-1")) {
					temp = ascQue.poll();
				}
				cnt--;

				System.out.println("delete " + temp);

			}
			
			if(cnt == 0) {
				ascQue.clear();
				descQue.clear();
			}

		}

		int[] answer = new int[2];

		if (cnt == 0) {

			answer[0] = 0;
			answer[1] = 0;
		} else {

			answer[0] = descQue.poll();
			answer[1] = ascQue.poll();
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] arr = { "I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6" };
		int[] rst = new Solution().solution(arr);
		System.out.println("[" + rst[0] + "," + rst[1] + "]");
	}
}