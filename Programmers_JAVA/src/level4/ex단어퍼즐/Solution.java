package level4.ex단어퍼즐;

class Solution {

	char[] target;
	char[][] arr;
	int[] dp;

	public int solution(String[] strs, String t) {

		target = t.toCharArray();
		arr = new char[strs.length][];
		for (int i = 0; i < strs.length; i++) {
			arr[i] = strs[i].toCharArray();
		}
		dp = new int[target.length + 1];
		int maxVal = Integer.MAX_VALUE;

		for (int dpi = 1; dpi < dp.length; dpi++) {
			dp[dpi] = maxVal;
			for (char[] pattern : arr) {
				if (pattern.length <= dpi && dp[dpi - pattern.length] > -1) {

					boolean flag = true;
					for (int idx = 0; idx < pattern.length; idx++) {
						flag &= pattern[idx] == target[dpi - pattern.length + idx];
					}
					if (flag) {
						dp[dpi] = Math.min(dp[dpi], dp[dpi - pattern.length] + 1);
					}

				}
			}
			if (dp[dpi] == maxVal)
				dp[dpi] = -1;
		}

		return dp[target.length];
	}

}