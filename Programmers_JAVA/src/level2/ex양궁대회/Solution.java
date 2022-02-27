package level2.ex양궁대회;

class Solution {

	int[] answer = { -1 };
	int cacheDif = 0;

	public int[] solution(int n, int[] info) {

		int[] ryan = new int[11];

		dfs(0, 0, n, ryan, info);

		return answer;
	}

	void dfs(int index, int shot, int n, int[] ryan, int[] apeach) {

		if (shot > n) {
			return;
		} else if (index == 10) {
			ryan[index] = n - shot;

			int ryanP = 0;
			int apeachP = 0;

			for (int i = 0; i < 11; i++) {
				if (ryan[i] > apeach[i]) {
					ryanP += 10 - i;
				} else if (apeach[i] > 0) {
					apeachP += 10 - i;
				}
			}

			int dif = ryanP - apeachP;

			if (cacheDif < dif) {
				answer = ryan.clone();
				cacheDif = dif;
			} else if (cacheDif == dif && dif > 0) {
				for (int i = 10; i > 0; i--) {
					if (ryan[i] > answer[i]) {
						answer = ryan.clone();
						return;
					} else if (ryan[i] < answer[i]) {
						return;
					}
				}
			}

		} else {

			int temp = ryan[index];
			int arrow = apeach[index] + 1;
			ryan[index] = 0;
			dfs(index + 1, shot, n, ryan, apeach);
			ryan[index] = arrow;
			dfs(index + 1, shot + arrow, n, ryan, apeach);
			ryan[index] = temp;

		}
	}
}