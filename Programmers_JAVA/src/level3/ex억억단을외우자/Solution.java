package level3.ex억억단을외우자;

import java.util.Arrays;

class Solution {

	public int[] solution(int e, int[] starts) {
		
		// [1] 1 ~ e 까지의 약수 갯수 counting
		int[] cnts = new int[e + 1];

		for (int i = 1; i <= e; i++) {
			for (int j = 1; j <= e / i; j++) {
				cnts[i * j]++;
			}
		}

		// [2] starts중 최소값 min ~ e 중 약수가 가장 많은 수 찾기
		int min = Arrays.stream(starts).min().getAsInt(), no = e, cnt = cnts[e];
		int[] arr = new int[e - min + 1];
		for (int num = e; num >= min; num--) {
			if (cnt <= cnts[num]) {
				no = num;
				cnt = cnts[num];
			}
			arr[num - min] = no;
		}

		for (int i = 0; i < starts.length; i++) {
			starts[i] = arr[starts[i] - min];
		}

		return starts;
	}
}