package level3.ex스타수열;

import java.util.HashMap;

class Solution {
	public int solution(int[] a) {

		HashMap<Integer, Integer> counter = new HashMap<>();
		for (int no : a)
			counter.compute(no, (k, v) -> v == null ? 1 : v + 1);

		int ans = 0;

		for (int val : counter.keySet()) {

			if (counter.get(val) <= ans)
				continue;

			int temp = 0;

			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] != val && a[i + 1] != val || a[i] == a[i + 1])
					continue;
				temp++;
				i++;
			}

			ans = Math.max(ans, temp);
		}
		return ans * 2;
	}
}