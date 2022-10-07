package level0.ex한번만등장한문자;

import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
	public String solution(String s) {

		char[] arr = s.toCharArray();

		HashSet<Character> allSet = new HashSet<>();
		HashSet<Character> duplSet = new HashSet<>();

		for (char ch : arr) {
			if (!allSet.add(ch))
				duplSet.add(ch);
		}

		allSet.removeAll(duplSet);

		PriorityQueue<Character> que = new PriorityQueue<>(allSet);
		StringBuilder sb = new StringBuilder();

		while (!que.isEmpty())
			sb.append(que.poll());

		return sb.toString();
	}
}