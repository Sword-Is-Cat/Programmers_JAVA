package level3.ex합승택시요금;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int n, int s, int a, int b, int[][] fares) {

		FloydWarshall fw = new FloydWarshall(n);

		for (int[] fare : fares)
			fw.inputFare(fare);

		fw.calculate();

		int answer = Integer.MAX_VALUE;

		for (int i = 1; i <= n; i++) {
			int costS = fw.getCost(i, s);
			int costA = fw.getCost(i, a);
			int costB = fw.getCost(i, b);
			if (costS != FloydWarshall.UNCONNECT && costA != FloydWarshall.UNCONNECT
					&& costB != FloydWarshall.UNCONNECT) {
				answer = Math.min(answer, costS + costA + costB);
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[][] arr = { { 2, 6, 6 }, { 6, 3, 7 }, { 4, 6, 7 }, { 6, 5, 11 }, { 2, 5, 12 }, { 5, 3, 20 }, { 2, 4, 8 },
				{ 4, 3, 9 } };
		new Solution().solution(6, 4, 5, 6, arr);
	}
}

class FloydWarshall {

	static final int UNCONNECT = -1;
	int[][] fares;
	int length;

	FloydWarshall(int n) {
		fares = new int[n + 1][n + 1];
		length = n;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i != j)
					fares[i][j] = UNCONNECT;
			}
		}
	}

	void inputFare(int[] fare) {
		inputFare(fare, true);
	}

	void inputFare(int[] fare, boolean isRound) {
		fares[fare[0]][fare[1]] = fare[2];
		if (isRound)
			fares[fare[1]][fare[0]] = fare[2];
	}

	int getCost(int i, int j) {
		int result = UNCONNECT;
		if (i != 0 && j != 0)
			result = fares[i][j];
		return result;
	}

	void calculate() {

		Queue<Integer> que = new LinkedList<>();
		for (int relay = 1; relay <= length; relay++)
			que.add(relay);

		while (!que.isEmpty()) {
			int relay = que.poll();
			for (int i = 1; i <= length; i++) {
				for (int j = 1; j <= length; j++) {
					if (getCost(i, relay) != UNCONNECT && getCost(relay, j) != UNCONNECT) {
						int relayCost = getCost(i, relay) + getCost(relay, j);
						int beforeCost = getCost(i, j);
						if (beforeCost == UNCONNECT || beforeCost > relayCost) {
							inputFare(new int[] { i, j, relayCost });
							if(!que.contains(i))que.add(i);
							if(!que.contains(j))que.add(j);
						}
					}
				}
			}
		}
	}
}