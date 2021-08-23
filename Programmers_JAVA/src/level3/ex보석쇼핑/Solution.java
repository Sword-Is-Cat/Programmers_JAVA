package level3.ex보석쇼핑;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int[] solution(String[] gems) {

		Map<String, Integer> map = new HashMap<>();
		int[] intgem = new int[gems.length];

		for (int i = 0; i < gems.length; i++) {
			if (map.containsKey(gems[i]))
				intgem[i] = map.get(gems[i]);
			else {
				int temp = map.size();
				map.put(gems[i], temp);
				intgem[i] = temp;
			}
		}

		int[] quantity = new int[map.size()];
		int startIndex = 0;
		int length = gems.length;

		int i = 0;
		int j = 0;
		quantity[intgem[0]]++;

		while (i + j < gems.length) {
			if (check(quantity)) {
				if (j < length) {
					startIndex = i;
					length = j;
				}
				quantity[intgem[i]]--;
				i++;
				j--;
			} else {
				j++;
				if (i + j == gems.length)
					break;
				quantity[intgem[i + j]]++;
			}
		}

		int[] answer = { 1 + startIndex, 1 + startIndex + length };
		return answer;
	}

	public boolean check(int[] quantity) {

		for (int i : quantity) {
			if (i == 0)
				return false;
		}
		return true;

	}
}