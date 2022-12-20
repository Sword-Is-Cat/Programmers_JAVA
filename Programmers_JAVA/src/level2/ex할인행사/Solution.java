package level2.ex할인행사;

import java.util.HashMap;

class Solution {
	public int solution(String[] want, int[] number, String[] discount) {

		// 원하는 상품명의 index를 획득하기 위한 map 구성
		initItemIndex(want);

		// 첫 10일간의 할인항목 중 원하는 상품 할인수를 카운트
		for (int i = 0; i < 10; i++) {
			addArrayValue(number, indexOf(discount[i]), -1);
		}

		int answer = 0;

		// 첫날부터 마지막날까지 순회하며 조건만족 확인 및 할인cnt 업데이트
		for (int date = 0; date + 9 < discount.length; date++) {

			// 첫날은 할인cnt 업데이트 하지 않는다
			if (date > 0) {
				addArrayValue(number, indexOf(discount[date + 9]), -1);
				addArrayValue(number, indexOf(discount[date - 1]), 1);
			}

			if (isAllZero(number)) {
				answer++;
			}
		}
		return answer;
	}

	HashMap<String, Integer> itemIdx;

	void initItemIndex(String[] array) {
		itemIdx = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			itemIdx.put(array[i], i);
		}
	}

	int indexOf(String item) {
		return itemIdx.containsKey(item) ? itemIdx.get(item) : -1;
	}

	void addArrayValue(int[] array, int index, int value) {
		if (-1 < index && index < array.length)
			array[index] += value;
	}

	boolean isAllZero(int[] number) {
		if (number == null)
			return false;
		for (int no : number) {
			if (no != 0)
				return false;
		}
		return true;
	}
}