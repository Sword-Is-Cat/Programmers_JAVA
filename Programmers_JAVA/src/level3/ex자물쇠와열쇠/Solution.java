package level3.ex자물쇠와열쇠;

class Solution {
	public boolean solution(int[][] key, int[][] lock) {
		return isMatch(key, lock, 0);
	}

	/*
	 * key배열을 이동시켜가며 match하는지 확인
	 * 모든 case의 이동에도 match하지 않으면 다음 case확인
	 * 원본->회전->회전->회전->반전->회전->회전->회전->return false;
	 */
	boolean isMatch(int[][] key, int[][] lock, int turn) {

		if (turn == 8)
			return false;

		for (int rowCr = 1 - lock.length; rowCr < key.length; rowCr++) {
			for (int colCr = 1 - lock[0].length; colCr < key[0].length; colCr++) {
				if (keyLockMatch(key, lock, rowCr, colCr))
					return true;
			}
		}

		return isMatch(turn == 3 ? mirrorArray(key) : turnArray(key), lock, turn + 1);
	}

	// key를 rowCr / colCr만큼 이동시킨 배열이 lock배열과 겹쳤을때 조건을 만족하는지 확인하는 method
	boolean keyLockMatch(int[][] key, int[][] lock, int rowCr, int colCr) {

		for (int i = 0; i < lock.length; i++) {
			for (int j = 0; j < lock[0].length; j++) {

				int keyV = 0;
				if (0 <= i + rowCr && i + rowCr < key.length && 0 <= j + colCr && j + colCr < key[0].length)
					keyV = key[i + rowCr][j + colCr];

				if (lock[i][j] + keyV != 1)
					return false;
			}
		}
		return true;
	}

	// 2D 배열을 반시계방향으로 90도 회전시키는 method
	int[][] turnArray(int[][] arr) {

		int[][] result = new int[arr[0].length][arr.length];

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = arr[arr.length - 1 - j][i];
			}
		}

		return result;
	}

	// 2D 배열을 상하 반전 시키는 method
	int[][] mirrorArray(int[][] arr) {

		int[][] result = new int[arr.length][arr[0].length];

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = arr[arr.length - 1 - i][j];
			}
		}

		return result;
	}
}