package level5.ex직사각형의넓이;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12974
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	public long solution(int[][] rectangles) {

		long answer = 0;

		Set<Integer> xSet = new HashSet<>();
		Set<Integer> ySet = new HashSet<>();

		for (int i = 0; i < rectangles.length; i++) {
			xSet.add(rectangles[i][0]);
			ySet.add(rectangles[i][1]);
			xSet.add(rectangles[i][2]);
			ySet.add(rectangles[i][3]);
		}

		List<Integer> xList = new ArrayList<>(xSet);
		List<Integer> yList = new ArrayList<>(ySet);
		
		Collections.sort(xList);
		Collections.sort(yList);

		boolean[][] zone = new boolean[xList.size() - 1][yList.size() - 1];

		for (int r = 0; r < rectangles.length; r++) {

			int x1 = xList.indexOf(rectangles[r][0]);
			int y1 = yList.indexOf(rectangles[r][1]);
			int x2 = xList.indexOf(rectangles[r][2]);
			int y2 = yList.indexOf(rectangles[r][3]);

			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					if (!zone[i][j]) {
						zone[i][j] = true;
						answer += (long)(xList.get(i + 1) - xList.get(i)) * (yList.get(j + 1) - yList.get(j));
					}
				}
			}

		}

		return answer;
	}
}