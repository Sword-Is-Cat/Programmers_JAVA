package level4.ex호텔방배정;

import java.util.HashMap;
import java.util.Map;

class Solution {

	Map<Long, Long> map;

	public long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		map = new HashMap<>();

		for (int i = 0; i < room_number.length; i++) {
			answer[i] = findEmptyRoom(room_number[i]);
		}

		return answer;
	}

	public long findEmptyRoom(long no) {
		if (!map.containsKey(no)) {
			map.put(no, no);
		} else {
			map.replace(no, findEmptyRoom(map.get(no) + 1));
		}

		return map.get(no);
	}
}