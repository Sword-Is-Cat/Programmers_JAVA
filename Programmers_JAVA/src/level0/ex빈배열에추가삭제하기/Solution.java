package level0.ex빈배열에추가삭제하기;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public int[] solution(int[] arr, boolean[] flag) {

		Deque<Integer> list = new ArrayDeque<>();

		for (int i = 0; i < arr.length; i++) {
			int cnt = arr[i];
			if (flag[i]) {
				cnt *= 2;
				while (cnt-- > 0) {
					list.add(arr[i]);
				}
			} else {
				while (cnt-- > 0) {
					list.removeLast();
				}
			}
		}

		return list.stream().mapToInt(i -> i).toArray();
	}
}