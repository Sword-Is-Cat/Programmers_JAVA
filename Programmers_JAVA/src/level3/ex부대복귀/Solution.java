package level3.ex부대복귀;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Solution {
	public int[] solution(int n, int[][] roads, int[] sources, int d) {

		int[] dist = new int[n + 1];
		Arrays.fill(dist, -1);
		dist[d] = 0;
		LinkedList<Integer> solve = new LinkedList<>();
		solve.add(d);
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

		for (int[] road : roads) {

			int d1 = road[0], d2 = road[1];

			if (!map.containsKey(d1)) {
				map.put(d1, new HashSet<>());
			}

			if (!map.containsKey(d2)) {
				map.put(d2, new HashSet<>());
			}

			map.get(d1).add(d2);
			map.get(d2).add(d1);

		}

		while (!solve.isEmpty()) {

			int point = solve.poll(), length = dist[point] + 1;

			for (int newP : map.get(point)) {

				if (dist[newP] == -1 || dist[newP] > length) {
					dist[newP] = length;
					solve.add(newP);
				}

			}

		}

		for (int i = 0; i < sources.length; i++)
			sources[i] = dist[sources[i]];

		return sources;
	}
}