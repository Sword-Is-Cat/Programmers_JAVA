package level3.ex여행경로;

import java.util.Arrays;

class Solution {
	public String[] solution(String[][] tickets) {

		Arrays.sort(tickets, (a, b) -> (a[1].compareTo(b[1])));
		boolean[] used = new boolean[tickets.length];
		String[] route = new String[tickets.length + 1];
		route[0] = "ICN";

		return proc(1, route, tickets, used) ? route : null;
	}

	public boolean proc(int index, String[] route, String[][] tickets, boolean[] used) {

		if (index == route.length) return true;

		for (int i = 0; i < tickets.length; i++) {
			if (!used[i] && tickets[i][0].equals(route[index - 1])) {
				route[index] = tickets[i][1];
				used[i] = true;
				if (proc(index + 1, route, tickets, used))
					return true;
				used[i] = false;
			}
		}
		return false;
	}
}