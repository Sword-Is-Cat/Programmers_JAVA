package level0.ex콜라츠수열만들기;

import java.util.ArrayList;

class Solution {
	public int[] solution(int n) {
		ArrayList<Integer> list = new ArrayList<>();

		while (n > 1) {
			list.add(n);
			n = n % 2 == 0 ? (n / 2) : (3 * n + 1);
		}
		list.add(1);

		return list.stream().mapToInt(i -> i).toArray();
	}
}