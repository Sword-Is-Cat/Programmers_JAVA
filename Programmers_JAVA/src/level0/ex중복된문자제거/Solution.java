package level0.ex중복된문자제거;

import java.util.HashSet;

class Solution {
	public String solution(String my_string) {

		StringBuilder sb = new StringBuilder();
		HashSet<Character> set = new HashSet<>();

		for (char ch : my_string.toCharArray()) {
			if (set.add(ch))
				sb.append(ch);
		}

		return sb.toString();
	}
}