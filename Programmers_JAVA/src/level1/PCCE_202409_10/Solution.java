package level1.PCCE_202409_10;

class Solution {
	public int solution(int[] mats, String[][] park) {

		int maxSize = 0;

		for (int r = 0; r < park.length; r++) {
			for (int c = 0; c < park[r].length; c++) {
				if ("-1".equals(park[r][c])) {
					maxSize = Math.max(maxSize, getSize(r, c, park));
				}
			}
		}

		int answer = -1;
		for (int i = 0; i < mats.length; i++) {
			if (mats[i] <= maxSize) {
				answer = Math.max(answer, mats[i]);
			}
		}
		return answer;
	}

	private int getSize(int r, int c, String[][] park) {

		int size = 1;

		while (true) {
			if (r + size == park.length || c + size == park[r].length)
				return size;
			for (int d = 0; d <= size; d++) {
				if (!"-1".equals(park[r + d][c + size]))
					return size;
				if (!"-1".equals(park[r + size][c + d]))
					return size;
			}
			size++;
		}

	}
}