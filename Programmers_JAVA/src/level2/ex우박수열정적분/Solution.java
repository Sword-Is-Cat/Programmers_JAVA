package level2.ex우박수열정적분;

import java.util.ArrayList;

class Solution {
	public double[] solution(int k, int[][] ranges) {

		ArrayList<Integer> values = new ArrayList<>();
		ArrayList<Integer> areas = new ArrayList<>();

		values.add(k);
		areas.add(0);
		int accumArea = 0;

		while (k > 1) {

			int area = k;

			if (k % 2 == 0) {
				k /= 2;
			} else {
				k = k * 3 + 1;
			}

			values.add(k);
			accumArea += area + k;
			areas.add(accumArea);

		}

		int last = values.size() - 1;
		double[] answer = new double[ranges.length];

		for (int i = 0; i < ranges.length; i++) {

			int[] range = ranges[i];

			if (last + range[1] < range[0]) {
				answer[i] = -1;
			} else {
				answer[i] = (areas.get(last + range[1]) - areas.get(range[0])) / 2.0D;
			}

		}

		return answer;
	}
}