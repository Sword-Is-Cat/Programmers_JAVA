package level3.ex등산코스정하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

	int[] info;
	ArrayList<ArrayList<int[]>> graph;

	public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

		// sort array (마지막 정산 시 간략화를 위해 필요)
		Arrays.sort(gates);
		Arrays.sort(summits);

		// 각 포인트의 정보 -1 : 게이트 / 1 : 봉우리
		info = new int[n + 1];

		for (int gate : gates) {
			info[gate] = -1;
		}

		for (int summit : summits) {
			info[summit] = 1;
		}

		// intensity 저장할 graph 자료구조
		graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		// 단방향 graph 구성
		for (int[] path : paths) {

			int s = path[0], e = path[1], w = path[2];

			if (info[s] != 1 && info[e] != -1) {
				graph.get(s).add(new int[] { e, w });
			}

			if (info[e] != 1 && info[s] != -1) {
				graph.get(e).add(new int[] { s, w });
			}

		}

		return process(n, gates, summits);
	}

	private int[] process(int n, int[] gates, int[] summits) {

		int[] intensity = new int[n + 1];
		Arrays.fill(intensity, 10000001);

		Queue<int[]> que = new PriorityQueue<>((a, b) -> (a[1] - b[1]));

		for (int gate : gates) {
			intensity[gate] = 0;
			que.add(new int[] { gate, 0 });
		}

		while (!que.isEmpty()) {
			int[] currEdge = que.poll();

			int currInten = intensity[currEdge[0]];

			if (currEdge[1] > currInten)
				continue;

			for (int[] nextEdge : graph.get(currEdge[0])) {

				int value = Math.max(currInten, nextEdge[1]);
				if (intensity[nextEdge[0]] > value) {
					intensity[nextEdge[0]] = value;
					que.add(new int[] { nextEdge[0], value });
				}
			}

		}

		int[] rst = { n + 1, 10000001 };

		for (int summit : summits) {
			if (intensity[summit] < rst[1]) {
				rst[1] = intensity[summit];
				rst[0] = summit;
			}
		}

		return rst;
	}

}