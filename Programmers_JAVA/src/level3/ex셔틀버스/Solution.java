package level3.ex셔틀버스;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class Solution {

	final int NINEOCLOCK = strToInt("09:00");

	public String solution(int n, int t, int m, String[] timetable) {

		Queue<Integer> memberQ = getCrewQ(timetable);
		Stack<Integer> bus = new Stack<>();

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {

			int busTime = NINEOCLOCK + i * t;
			bus.clear();
			int crew = -1;

			while (bus.size() < m && !memberQ.isEmpty() && memberQ.peek() <= busTime) {
				crew = memberQ.poll();
				bus.add(crew);
			}

			if (bus.size() == m)
				max = Math.max(max, bus.peek() - 1);
			else
				max = Math.max(max, busTime);

		}

		return intToStr(max);
	}

	public PriorityQueue<Integer> getCrewQ(String[] timetable) {
		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		for (String time : timetable)
			que.add(strToInt(time));
		return que;
	}

	public int strToInt(String time) {

		int result = 0;
		String[] times = time.split(":");

		result += Integer.parseInt(times[0]);
		result *= 60;
		result += Integer.parseInt(times[1]);

		return result;
	}

	public String intToStr(int time) {

		StringBuilder sb = new StringBuilder();
		boolean hhZero = time / 60 < 10, mmZero = time % 60 < 10;
		return sb.append(hhZero ? "0" : "").append(time / 60).append(':').append(mmZero ? "0" : "").append(time % 60)
				.toString();
	}
}