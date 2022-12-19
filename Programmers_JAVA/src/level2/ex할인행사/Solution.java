package level2.ex할인행사;

import java.util.HashMap;

class Solution {
	public int solution(String[] want, int[] number, String[] discount) {

		// 원하는 상품명의 index를 획득하기 위한 map 구성
		HashMap<String, Integer> itemIdx = new HashMap<>();
		for (int i = 0; i < want.length; i++) {
			itemIdx.put(want[i], i);
		}

		// 첫 10일간의 할인항목 중 원하는 상품 할인수를 카운트
		int[] dcCnt = new int[want.length];
		for (int i = 0; i < 10; i++) {
			if (itemIdx.containsKey(discount[i]))
				dcCnt[itemIdx.get(discount[i])]++;
		}

		int answer = 0;

		// 첫날부터 마지막날까지 순회하며 조건만족 확인 및 할인cnt 업데이트
		for (int date = 0; date + 9 < discount.length; date++) {

			// 첫날은 할인cnt 업데이트 하지 않는다
			if (date > 0) {

				// 다음 할인 품목 cnt추가
				String nextSale = discount[date + 9];
				if (itemIdx.containsKey(nextSale))
					dcCnt[itemIdx.get(nextSale)]++;
				// 마지막 할인품목 cnt제거
				String lastSale = discount[date - 1];
				if (itemIdx.containsKey(lastSale))
					dcCnt[itemIdx.get(lastSale)]--;
			}

			if (isSame(number, dcCnt)) {
				answer++;
			}
		}
		return answer;
	}

	boolean isSame(int[] number, int[] dcCnt) {
		if (number.length != dcCnt.length)
			return false;
		for (int i = 0; i < number.length; i++) {
			if (number[i] != dcCnt[i])
				return false;
		}
		return true;
	}
}