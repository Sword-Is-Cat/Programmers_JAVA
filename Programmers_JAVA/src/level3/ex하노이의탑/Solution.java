package level3.ex하노이의탑;

import java.util.ArrayList;
import java.util.List;

class Solution {

	List<int[]> list;

	public int[][] solution(int n) {

		list = new ArrayList<>();

		hanoi(n, 1, 3);
		
		int[][] answer = new int[list.size()][];

		return list.toArray(answer);
	}

	public void hanoi(int n, int from, int to) {

		int[] arr = { from, to };

		if (n == 1) {
			
			list.add(arr);
		} else {

			hanoi(n - 1, from, 6 - from - to);
			list.add(arr);
			hanoi(n - 1, 6 - from - to, to);

		}

	}

}