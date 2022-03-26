package level2.ex피로도;

class Solution {
	public int solution(int k, int[][] dungeons) {

		boolean[] visit = new boolean[dungeons.length];

		return dfs(k, dungeons, visit, 0);
	}

	int dfs(int stamina, int[][] dungeons, boolean[] visit, int cnt) {

		int result = cnt;

		for (int i = 0; i < dungeons.length; i++) {
			if (!visit[i] && stamina >= dungeons[i][0]) {
				visit[i] = true;
				result = Math.max(result, dfs(stamina - dungeons[i][1], dungeons, visit, cnt + 1));
				visit[i] = false;
			}
		}
		return result;
	}
}