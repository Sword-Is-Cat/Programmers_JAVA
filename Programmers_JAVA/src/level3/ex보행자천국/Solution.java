package level3.ex보행자천국;

class Solution {

	final static int MOD = 20170805;
	Road[][] cells;
	int mLeng;
	int nLeng;

	public int solution(int m, int n, int[][] cityMap) {

		mLeng = cityMap.length;
		nLeng = cityMap[0].length;

		cells = new Road[mLeng][nLeng];

		for (int i = 0; i < mLeng; i++) {
			for (int j = 0; j < nLeng; j++) {
				
				if(i == 0 && j == 0)
					cells[i][j] = new Road();
				else
					cells[i][j] = new Road(getCell(i, j, 'U'), getCell(i, j, 'L'), cityMap[i][j]);
			}
		}
		return cells[mLeng-1][nLeng-1].getCountPath();
	}

	public Road getCell(int i, int j) {
		return (i >= 0 && j >= 0 && i < mLeng && j < nLeng) ? cells[i][j] : null;
	}

	public Road getCell(int i, int j, char direct) {
		return direct == 'L' ? getCell(i - 1, j) : direct == 'U' ? getCell(i, j - 1) : null;
	}

}

class Road {

	int fromUp;
	int fromLeft;
	int pathType;

	Road() {
		this.fromUp = 1;
		this.fromLeft = 0;
		this.pathType = 0;
	}

	Road(Road up, Road left, int pathType) {

		this.pathType = pathType;

		fromUp = 0;

		if (up != null) {
			if (up.pathType == 0) {
				fromUp = up.fromUp + up.fromLeft;
			} else if (up.pathType == 2) {
				fromUp = up.fromUp;
			}
		}

		fromUp %= Solution.MOD;

		fromLeft = 0;

		if (left != null) {
			if (left.pathType == 0) {
				fromLeft = left.fromUp + left.fromLeft;
			} else if (left.pathType == 2) {
				fromLeft = left.fromLeft;
			}
		}

		fromLeft %= Solution.MOD;
	}

	public int getCountPath() {
		return (fromUp + fromLeft) % Solution.MOD;
	}
}