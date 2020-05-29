package level4.ex게임맵최단거리;
// 깊이우선탐색 : 정확성은 통과되나 효율성에서 TimeOut

class Solution {

	int n;
	int m;
	int[][] maps;
	boolean[][] visit;

	public int solution(int[][] maps) {

		n = maps.length;
		m = maps[0].length;
		this.maps = maps;
		visit = new boolean[n][m];

		search(0, 0, 1);

		return this.maps[n - 1][m - 1] == 1 ? -1 : this.maps[n - 1][m - 1];
	}

	public void search(int i, int j, int distance) {

		if (maps[i][j] == 0 || visit[i][j])
			return;

		if(i+j!=0){
			if(maps[i][j]==1)
				maps[i][j] = distance;
			else{
				if(maps[i][j] <= distance)
					return;
				else
					maps[i][j] = distance;
			}
		}

		visit[i][j] = true;

		if (i > 0)
			search(i - 1, j, distance+1);
		if (i + 1 < n)
			search(i + 1, j, distance+1);
		if (j > 0)
			search(i, j - 1, distance+1);
		if (j + 1 < m)
			search(i, j + 1, distance+1);

		visit[i][j] = false;
	}
}