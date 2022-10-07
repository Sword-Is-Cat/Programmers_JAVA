package level0.ex소인수분해;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
	public int[] solution(int n) {

		int div = 2;
		HashSet<Integer> set = new HashSet<>();

		while (n > 1) {

			while (n % div == 0) {
				set.add(div);
				n /= div;
			}
			div++;

		}

		int[] arr = new int[set.size()];

		int idx = 0;

		for (int no : set)
			arr[idx++] = no;

		Arrays.sort(arr);

		return arr;
	}
}