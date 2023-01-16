package level2.ex이모티콘할인행사;

class Solution {
	public int[] solution(int[][] users, int[] emoticons) {
		return dfs(users, emoticons, new int[emoticons.length], 0);
	}

	int[] dfs(int[][] users, int[] emoticons, int[] discounts, int idx) {

		if (idx == emoticons.length)
			return calc(users, emoticons, discounts);

		int[] rst = { 0, 0 };
		// 각 이모티콘들에 대해 10~40 할인율 각각 셋팅 후 계산하여 최대값 추출
		if (idx < emoticons.length) {
			for (int dis = 10; dis <= 40; dis += 10) {
				discounts[idx] = dis;
				int[] temp = dfs(users, emoticons, discounts, idx + 1);
				if (rst[0] < temp[0] || (rst[0] == temp[0] && rst[1] < temp[1]))
					rst = temp;
			}
		}
		return rst;
	}

	int[] calc(int[][] users, int[] emoticons, int[] discounts) {

		int cntPlusSubs = 0, totalSales = 0;

		for (int[] user : users) {

			int dcCut = user[0];
			int salesCut = user[1];
			int sales = 0;

			for (int i = 0; i < emoticons.length; i++) {
				if (discounts[i] >= dcCut)
					sales += emoticons[i] / 100 * (100 - discounts[i]);
			}

			if (sales >= salesCut)
				cntPlusSubs++;
			else
				totalSales += sales;

		}

		return new int[] { cntPlusSubs, totalSales };
	}
}