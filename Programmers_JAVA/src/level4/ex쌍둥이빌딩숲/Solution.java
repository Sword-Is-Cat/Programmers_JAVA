package level4.ex쌍둥이빌딩숲;

class Solution {

	int[][] cache;
	static final int MOD = 1000000007;

	public int solution(int n, int count) {
		cache = new int[n + 1][count + 1];
		return dfs(n, count);
	}

	int dfs(int remain, int show) {

		// 모든 건물을 세운 경우, 가능한 경우라면 1, 불가능이라면 0을 리턴
		if (remain == 0)
			return show == 0 ? 1 : 0;

		if (remain < show || show < 0)
			return 0;

		if (cache[remain][show] == 0) {

			long result = 0;

			// 보이는경우
			result += dfs(remain - 1, show - 1);

			// 안보이는경우
			long temp = dfs(remain - 1, show);
			result += temp * (remain - 1) * 2;

			cache[remain][show] = (int) (result % MOD);

		}

		return cache[remain][show];
	}

}