package level0.ex문자열정렬하기;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
	public int[] solution(String my_string) {
		ArrayList<Integer> list = new ArrayList<>();

		for (char ch : my_string.toCharArray()) {
			if ('0' <= ch && ch <= '9')
				list.add(ch - '0');
		}

		Collections.sort(list);

		int[] arr = new int[list.size()];
		for (int i = 0; i < arr.length; i++)
			arr[i] = list.get(i);
		return arr;
	}
}