package level4.ex트리트리오중간값;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int n, int[][] edges) {

		// 그래프 정리
		ArrayList<Integer>[] conn = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			conn[i] = new ArrayList<>();

		for (int[] edge : edges) {
			conn[edge[0]].add(edge[1]);
			conn[edge[1]].add(edge[0]);
		}
		// !그래프 정리

		// 임의의 리프노드 수집
		int leaf = 0;
		for (int i = 1; i <= n; i++) {
			if (conn[i].size() == 1) {
				leaf = i;
				break;
			}
		}
		// !임의의 리프노드 수집

		int[] curr = infoFromNode(conn, leaf), prev = null;

		while (prev == null || curr[0] != prev[0]) {
			prev = curr;
			curr = infoFromNode(conn, prev[1]);
		}

		return curr[0] - (Math.max(curr[2], prev[2]) == 1 ? 1 : 0);
	}

	protected int[] infoFromNode(ArrayList<Integer>[] conn, int index) {
		int maxDist = 0, target = -1, cnt = 0;
		int[] dist = new int[conn.length];
		Queue<int[]> que = new LinkedList<>();
		for (int idx : conn[index])
			que.add(new int[] { idx, 1 });
		while (!que.isEmpty()) {
			int[] arr = que.poll();
			if (index != arr[0] && dist[arr[0]] == 0) {
				dist[arr[0]] = arr[1];
				for (int idx : conn[arr[0]])
					que.add(new int[] { idx, arr[1] + 1 });
			}
		}

		for (int i = 1; i < conn.length; i++) {
			if (maxDist < dist[i]) {
				maxDist = dist[i];
				target = i;
				cnt = 1;
			} else if (maxDist == dist[i]) {
				cnt++;
			}
		}

		return new int[] { maxDist, target, cnt };
	}
}