package level1.ex정수내림차순으로배치하기;

import java.util.Arrays;

class Solution {
	public long solution(long n) {
		char[] arr = Long.toString(n).toCharArray();
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder(new String(arr));
		return Long.parseLong(sb.reverse().toString());
	}
}