package level2.ex주차요금계산;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Solution {
	public int[] solution(int[] fees, String[] records) {

		Map<String, Integer> carsInTime = new HashMap<>();
		Map<String, Integer> carsStayTime = new HashMap<>();
		Map<String, Integer> carsFee = new HashMap<>();
		Set<String> carsNumSet = new HashSet<>();
		Queue<String> carsNum = new PriorityQueue<>();

		for (String record : records) {

			String[] detail = record.split(" ");

			int time = timeStrToInt(detail[0]);
			String carNum = detail[1];
			String typeIO = detail[2];

			if ("IN".equals(typeIO)) {

				if (carsNumSet.add(carNum)) {
					carsNum.add(carNum);
				}

				carsInTime.put(carNum, time);

			} else if ("OUT".equals(typeIO)) {

				int inTime = carsInTime.get(carNum);
				carsInTime.remove(carNum, inTime);

				carsStayTime.put(carNum,
						time - inTime + (carsStayTime.containsKey(carNum) ? carsStayTime.get(carNum) : 0));

			}

		}

		for (String carNum : carsInTime.keySet()) {

			int time = 1439;
			int inTime = carsInTime.get(carNum);

			carsStayTime.put(carNum, time - inTime + (carsStayTime.containsKey(carNum) ? carsStayTime.get(carNum) : 0));

		}

		for (String carNum : carsStayTime.keySet()) {

			carsFee.put(carNum, calculateFee(fees, carsStayTime.get(carNum)));

		}

		int[] answer = new int[carsNum.size()];
		int index = 0;

		while (!carsNum.isEmpty()) {
			answer[index++] = carsFee.get(carsNum.poll());
		}

		return answer;
	}

	int timeStrToInt(String time) {
		String[] times = time.split(":");
		int hour = Integer.parseInt(times[0]);
		int min = Integer.parseInt(times[1]);
		return hour * 60 + min;
	}

	int calculateFee(int[] fees, int min) {

		int fee = fees[1];

		if (min > fees[0]) {
			fee += fees[3] * (int) Math.ceil((min - fees[0]) / (double) fees[2]);
		}

		return fee;

	}

	public static void main(String[] args) {
		int[] fees = { 180, 5000, 10, 600 };
		String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
				"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
		int[] result = new Solution().solution(fees, records);
		for (int row : result)
			System.out.println(row);
	}

}