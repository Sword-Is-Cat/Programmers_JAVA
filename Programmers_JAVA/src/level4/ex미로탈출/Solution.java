package level4.ex미로탈출;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {

	HashMap<Integer, Integer> trapMap;
	int[][] costs;

	public int solution(int n, int start, int end, int[][] roads, int[] traps) {

		// trap의 roomNo -> trapIndex 를 수행하는 자료구조 선언 및 data input
		trapMap = new HashMap<>();
		for (int i = 0; i < traps.length; i++) {
			trapMap.put(traps[i], i);
		}

		// from -> to 를 costs[from][to]로 저장할 2D array선언 (cost == -1은 이동불가)
		costs = new int[n + 1][n + 1];
		for (int[] cost : costs) {
			Arrays.fill(cost, -1);
		}

		// 정/역방향 관계없이 방마다 연결된 roomNo 저장할 Collection
		ArrayList<HashSet<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new HashSet<>());
		}

		// costs와 graph에 data input
		for (int[] road : roads) {

			int s = road[0], e = road[1], c = road[2];
			if (costs[s][e] == -1 || c < costs[s][e]) {
				costs[s][e] = c;
			}

			graph.get(s).add(e);
			graph.get(e).add(s);

		}

		// dp[roomNo][trapState] 진행상태 저장할 2D array
		int[][] dp = new int[n + 1][1 << traps.length];
		for (int[] singleRow : dp) {
			Arrays.fill(singleRow, -1);
		}

		// Heap Collection, 누적cost오름차순 선언 및 초기데이터 삽입
		PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[2] - b[2]);// {position, state, accumCost}
		que.add(new int[] { start, 0, 0 });

		while (!que.isEmpty()) {

			int[] info = que.poll();
			int posi = info[0], state = info[1], accumCost = info[2];

			// 목적지 도착시
			if (posi == end)
				return accumCost;

			// 이미 현재 상태보다 최적화된 결과값이 있는 경우 무시
			if (dp[posi][state] != -1 && dp[posi][state] <= accumCost)
				continue;

			dp[posi][state] = accumCost;

			for (int next : graph.get(posi)) {
				int cost = getCost(posi, next, state);
				// 제자리이동 불가, 이동불가케이스 제외
				if (posi == next || cost == -1)
					continue;
				que.add(new int[] { next, changeTrapState(next, state), accumCost + cost });
			}

		}

		return -1;
	}

	private int getCost(int from, int to, int trapState) {
		return isConnectReverse(from, to, trapState) ? costs[to][from] : costs[from][to];
	}

	private boolean isConnectReverse(int from, int to, int trapState) {
		return (getTrapped(from, trapState) ^ getTrapped(to, trapState)) == 1;
	}

	private int getTrapped(int roomNo, int trapState) {
		if (trapMap.containsKey(roomNo)) {
			return (trapState >> trapMap.get(roomNo)) & 1;
		}
		return 0;
	}

	private int changeTrapState(int roomNo, int trapState) {
		if (trapMap.containsKey(roomNo)) {
			trapState ^= 1 << trapMap.get(roomNo);
		}
		return trapState;
	}
}