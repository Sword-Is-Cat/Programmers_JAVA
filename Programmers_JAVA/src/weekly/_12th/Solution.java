package weekly._12th;

class Solution {

	public int solution(int k, int[][] dungeons) {

		boolean[] visit = new boolean[dungeons.length];

		return proc(k, dungeons, visit);

	}

	public int proc(int fatigue, int[][] dungeons, boolean[] visit) {

		int result = -1;

		for (int i = 0; i < visit.length; i++) {

			int[] dungeon = dungeons[i];
			int fatiRequire = dungeon[0];
			int fatiReduce = dungeon[1];

			if (!visit[i] && fatigue >= fatiRequire) {

				visit[i] = true;

				result = Math.max(result, proc(fatigue - fatiReduce, dungeons, visit));

				visit[i] = false;

			}

		}

		return result + 1;

	}

}