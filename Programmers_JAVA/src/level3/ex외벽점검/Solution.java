package level3.ex외벽점검;

class Solution {

	// 나올수 없는 최대값 (인원수 max8명)
	int answer = 9;

	public int solution(int n, int[] weak, int[] dist) {

		int[] weakFull = new int[weak.length * 2];
		for (int i = 0; i < weak.length; i++) {
			weakFull[i] = weak[i];
			weakFull[i + weak.length] = weak[i] + n;
		}

		boolean[] visit = new boolean[dist.length];

		for (int start = 0; start < weak.length; start++) {
			dfs(start, start, -1, weakFull, dist, visit, 0);
		}

		return answer > dist.length ? -1 : answer;
	}

	/***
	 * @param start		점검을 시작한 idx
	 * @param current	현재 점검중인 idx
	 * @param coverage	현재 점검인원이 점검가능한 최대 위치
	 * @param weak		점검위치배열(length x2)
	 * @param dist		각 인원별 점검가능 거리
	 * @param visit		각 인원별 점검 진행여부
	 * @param count		현재까지 투입된 인원수
	 */
	private void dfs(int start, int current, int coverage, int[] weak, int[] dist, boolean[] visit, int count) {

		if (start + weak.length / 2 <= current) {
			// 종료조건
			answer = Math.min(answer, count);
		} else if (weak[current] <= coverage) {
			// 추가인원 배치 불필요
			dfs(start, current + 1, coverage, weak, dist, visit, count);
		} else {
			// 추가인원 배치
			for (int i = 0; i < dist.length; i++) {

				if (!visit[i]) {
					visit[i] = true;
					dfs(start, current + 1, weak[current] + dist[i], weak, dist, visit, count + 1);
					visit[i] = false;
				}
			}
		}

	}
}