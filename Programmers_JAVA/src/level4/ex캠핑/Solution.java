package level4.ex캠핑;

import java.util.Arrays;

class Solution {
	public int solution(int n, int[][] data) {

		int answer = 0;

		Arrays.sort(data, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));

		for (int i = 0; i < data.length - 1; i++) {

			int under = 0;
			int[] stand = data[i];

			for (int j = i + 1; j < data.length; j++) {

				int[] target = data[j];
				if (stand[0] == target[0])
					continue;

				if (stand[1] > target[1] && target[1] >= under) {
					answer++;
					under = target[1];
				}
			}
		}

		Arrays.sort(data, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));

		for (int i = 0; i < data.length - 1; i++) {

			int over = Integer.MAX_VALUE;
			int[] stand = data[i];

			for (int j = i + 1; j < data.length; j++) {

				int[] target = data[j];
				if (stand[0] == target[0])
					continue;

				if (stand[1] < target[1] && target[1] <= over) {
					answer++;
					over = target[1];
				}
			}
		}
		return answer;
	}
}