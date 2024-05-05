package level4.ex짝수행세기;

class Solution {

	final int MOD = (int) 1e7 + 19;

	public int solution(int[][] a) {

		combCache = new int[a.length + 1][a.length + 1];

		// 처리한col개수 / 홀수행갯수 -> 경우의수
		long[][] dp = new long[a[0].length + 1][a.length + 1];
		dp[0][0] = 1;

		for (int i = 1; i < dp.length; i++) {
			int col = i - 1, vari = countColOne(a, col);
			// i: 현재 계산하는 열번호, col: 직전 열번호
			for (int j = 0; j < dp[i].length; j++) {
				if (dp[col][j] == 0)
					continue;
				// j: 이전 열에서 홀수행개수
				for (int dec = 0; dec <= vari; dec++) {
					int inc = vari - dec; // inc: 0->1이되는 행 수, dec: 1->0이 되는 행 수
					if (j < dec || a.length - j < inc)
						continue;
					dp[i][j + inc - dec] += ((dp[col][j] * comb(j, dec)) % MOD * comb(a.length - j, inc)) % MOD;
					dp[i][j + inc - dec] %= MOD;
				}
			}
		}

		return (int) dp[dp.length - 1][0];
	}

	private int countColOne(int[][] a, int col) {
		int cnt = 0;
		for (int i = 0; i < a.length; i++)
			cnt += a[i][col];
		return cnt;
	}

	private int[][] combCache;

	private int comb(int a, int b) {
		if (a < b)
			return 0;
		if (a < 2 * b)
			return comb(a, a - b);
		if (b == 0)
			return 1;
		if (combCache[a][b] == 0) {
			combCache[a][b] = (comb(a - 1, b - 1) + comb(a - 1, b)) % MOD;
		}
		return combCache[a][b];
	}

}