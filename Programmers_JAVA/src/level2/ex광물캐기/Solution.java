package level2.ex광물캐기;

import java.util.Arrays;

class Solution {
	public int solution(int[] picks, String[] minerals) {

		int totalPick = picks[0] + picks[1] + picks[2];
		int mineralCnt = Math.min(totalPick * 5, minerals.length);
		int[][] mGroup = new int[(mineralCnt + 4) / 5][3];

		int idx = -1;
		for (int i = 0; i < mineralCnt; i++) {
			if (i % 5 == 0)
				idx++;
			int si = 2;
			switch (minerals[i]) {
			case "diamond":
				si--;
			case "iron":
				si--;
			default:
				mGroup[idx][si]++;
			}
		}

		Arrays.sort(mGroup, (b, a) -> a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);

		int spend = 0, gIdx = 0;

		while (gIdx < mGroup.length) {
			int[] mines = mGroup[gIdx++];
			if (picks[0]-- > 0) {
				spend += mines[0] + mines[1] + mines[2];
			} else if (picks[1]-- > 0) {
				spend += mines[0] * 5 + mines[1] + mines[2];
			} else if (picks[2]-- > 0) {
				spend += mines[0] * 25 + mines[1] * 5 + mines[2];
			}
		}
		return spend;
	}
}