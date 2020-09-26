package level3.ex단속카메라;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public int solution(int[][] routes) {

		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int cam = 0;
		int camEnd = -30001;

		for (int[] route : routes) {

			if (route[0] > camEnd) {
				cam++;
				camEnd = route[1];
			} else
				camEnd = Math.min(camEnd, route[1]);
		}
		return cam;
	}
}