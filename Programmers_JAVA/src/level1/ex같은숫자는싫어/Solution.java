package level1.ex같은숫자는싫어;

import java.util.ArrayList;

public class Solution {
	public int[] solution(int[] arr) {

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (i == 0 || arr[i - 1] != arr[i]) {
				list.add(arr[i]);
			}
		}

		return list.stream().mapToInt(i -> i).toArray();
	}
}