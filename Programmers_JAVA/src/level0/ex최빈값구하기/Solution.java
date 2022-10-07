package level0.ex최빈값구하기;

import java.util.HashMap;

class Solution {
	public int solution(int[] array) {

		HashMap<Integer, Integer> counter = new HashMap<>();

		for (int no : array) {

			if (!counter.containsKey(no))
				counter.put(no, 0);

			counter.put(no, counter.get(no) + 1);

		}

		int value = -10001, cnt = 0;
		boolean dupl = false;

		for (int no : counter.keySet()) {

			int noCnt = counter.get(no);

			if (cnt < noCnt) {
				value = no;
				cnt = noCnt;
				dupl = false;
			} else if (cnt == noCnt) {
				dupl = true;
			}

		}

		return dupl ? -1 : value;
	}
}