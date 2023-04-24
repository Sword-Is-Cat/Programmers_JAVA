package level0.ex배열의원소만큼추가하기;

import java.util.ArrayList;

class Solution {
	public int[] solution(int[] arr) {

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			int cnt = arr[i];
			while (cnt-- > 0) {
				list.add(arr[i]);
			}
		}

		return list.stream().mapToInt(i -> i).toArray();
	}
}