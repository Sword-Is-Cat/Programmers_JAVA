package level3.ex상담원인원;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	public int solution(int k, int n, int[][] reqs) {

		int[][] waits = new int[k + 1][n - k + 2];

		for (int type = 1; type < waits.length; type++) {
			for (int mans = 1; mans < waits[type].length; mans++) {
				waits[type][mans] = simulate(type, mans, reqs);
			}
		}

		int[] counts = new int[k + 1];
		Arrays.fill(counts, 1);
		int total = k;

		while (total < n) {
			int index = 0, max = 0;
			for (int type = 1; type < counts.length; type++) {
				int mans = counts[type];
				if (mans == waits[type].length - 1)
					continue;
				int gap = waits[type][mans] - waits[type][mans + 1];
				if (max < gap) {
					index = type;
					max = gap;
				}
			}
			counts[index]++;
			total++;
		}

		int answer = 0;

		for (int type = 1; type < counts.length; type++) {
			answer += waits[type][counts[type]];
		}

		return answer;
	}

	private int simulate(int type, int mans, int[][] reqs) {

		PriorityQueue<Integer> que = new PriorityQueue<>();

		while (que.size() < mans) {
			que.add(0);
		}

		int wait = 0;

		for (int[] req : reqs) {
			if (req[2] == type) {
				int next = que.poll();
				if (req[0] < next) {
					wait += next - req[0];
				}
				que.add(Math.max(next, req[0]) + req[1]);
			}
		}

		return wait;
	}
}