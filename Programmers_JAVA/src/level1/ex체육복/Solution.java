package level1.ex체육복;

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {

		int[] cnts = new int[n];

		for (int idx : lost) {
			cnts[idx - 1]--;
		}

		for (int idx : reserve) {
			cnts[idx - 1]++;
		}

		for (int i = 1; i < n; i++) {
			if (cnts[i] * cnts[i - 1] < 0) {
				cnts[i] = cnts[i - 1] = 0;
			}
		}

		for (int cnt : cnts) {
			if (cnt < 0) {
				n--;
			}
		}

		return n;
	}
}