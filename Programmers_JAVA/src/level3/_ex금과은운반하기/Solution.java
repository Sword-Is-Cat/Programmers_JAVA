package level3._ex금과은운반하기;

class Solution {

	/**
	 * @param a 금 필요량
	 * @param b 은 필요량
	 * @param g 도시별 금 보유량
	 * @param s 도시별 은 보유량
	 * @param w 도시별 트럭 용량
	 * @param t 도시별 트럭 이동시간
	 * @return
	 */
	public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {

		long head = 0;
		long tail = Long.MAX_VALUE / 100;
		long mid = -1;

		while (tail - head > 1) {

			mid = (tail + head) / 2;

			boolean possible = checkPossible(a, b, g, s, w, t, mid);

			// System.out.println(mid + " sec : " + (possible ? "able" : "disable"));

			if (possible)
				tail = mid;
			else
				head = mid;

		}

		return tail;
	}

	public boolean checkPossible(int a, int b, int[] g, int[] s, int[] w, int[] t, long sec) {

		int totalNeed = a + b;

		for (int i = 0; i < g.length; i++) {

			long maxTruck = ((sec / t[i] + 1) / 2) * w[i];
			int max = (int) Math.min((long) Integer.MAX_VALUE, maxTruck);

			int gold = Math.min(g[i], max);
			int silver = Math.min(s[i], max);
			int total = Math.min(gold + silver, max);

			if (a > 0)
				a -= gold;
			if (b > 0)
				b -= silver;
			if (totalNeed > 0)
				totalNeed -= total;

		}

		return !(a > 0 || b > 0 || totalNeed > 0);

	}

}