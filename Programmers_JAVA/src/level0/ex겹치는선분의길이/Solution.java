package level0.ex겹치는선분의길이;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	public int solution(int[][] lines) {

		PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		for (int[] line : lines) {
			Arrays.sort(line);
			que.add(new int[] { line[0], 1 });
			que.add(new int[] { line[1], -1 });
		}

		int answer = 0, thick = 0, posi = que.peek()[0], prev = -101;

		while (!que.isEmpty()) {

			prev = posi;
			posi = que.peek()[0];

//			System.out.println("[ " + prev + " ~ " + posi + " ] 구간 두께 " + thick);
			if (thick > 1)
				answer += posi - prev;
//			System.out.println("누적 answer : " + answer);

			while (!que.isEmpty() && que.peek()[0] == posi) {
				thick += que.poll()[1];
			}
		}
		return answer;
	}
}