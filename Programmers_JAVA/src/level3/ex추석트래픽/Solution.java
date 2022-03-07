package level3.ex추석트래픽;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	final boolean DEBUG = false;

	public int solution(String[] lines) {

		Queue<Integer> startTQ = new PriorityQueue<>();
		Queue<Integer> endTQ = new PriorityQueue<>();

		for (String line : lines) {
			lineParser(line, startTQ, endTQ);
		}

		int answer = 0;
		int temp = 0;
		while (!startTQ.isEmpty()) {
			int start = startTQ.peek();
			int end = endTQ.peek();
			if (end < start) {
				endTQ.poll();
				temp--;
			} else {
				startTQ.poll();
				temp++;
				answer = Math.max(answer, temp);
			}
		}

		return answer;
	}

	void lineParser(String line, Queue<Integer> startTQ, Queue<Integer> endTQ) {
		String[] arr = line.split(" ");

		int time = timeParser(arr[1]);
		int proc = secParser(arr[2].replace("s", ""));
		startTQ.add(time - proc + 1);
		endTQ.add(time + 999);

	}

	int timeParser(String hhmmss) {
		String[] arr = hhmmss.split(":");
		int hh = Integer.parseInt(arr[0]);
		int mm = Integer.parseInt(arr[1]);
		int ms = Integer.parseInt(arr[2].replace(".", ""));

		mm = hh * 60 + mm;
		ms = mm * 60 * 1000 + ms;
		print("timeParse: " + hhmmss + ", result: " + ms);
		return ms;
	}

	int secParser(String sec) {

		String[] arr = sec.split("[^0-9]");
		int result = Integer.parseInt(arr[0]) * 1000;
		if (arr.length > 1) {
			String ms = arr[1];
			while (ms.length() < 3) {
				ms += "0";
			}
			result += Integer.parseInt(ms);
		}

		print("secParse: " + sec + ", result: " + result);
		return result;
	}

	void print(Object obj) {
		if (DEBUG)
			System.out.println(obj);
	}

	public static void main(String[] args) {
		new Solution().solution(new String[] { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" });
	}
}