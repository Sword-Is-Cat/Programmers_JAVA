package level2.ex위장;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
	public int solution(String[][] clothes) {

		// 의상 종류별로 갯수만 count
		HashMap<String, Integer> counter = new HashMap<>();
		Arrays.stream(clothes).map(arr -> ((String[]) arr)[1])
				.forEach(type -> counter.compute(type, (k, v) -> v == null ? 1 : v + 1));

		// 하나의 의상종류에 대해 옷의 가지수+1(미착용) 포함하여 경우의수 구하기
		int ans = 1;
		for (Integer cnt : counter.values())
			ans *= cnt + 1;

		// 아무것도 안입는 1가지 제외하고 return
		return ans - 1;
	}
}