package level1.ex둘만의암호;

import java.util.Arrays;

class Solution {

	int[] cnt;

	public String solution(String s, String skip, int index) {

		cnt = new int[26];
		Arrays.fill(cnt, 1);

		for (char sk : skip.toCharArray()) {
			cnt[sk - 'a'] = 0;
		}

		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = decode(arr[i], index);
		}

		return new String(arr);
	}

	protected char decode(char ch, int index) {

		int sum = 0;

		while (sum < index) {
			sum += cnt[(++ch - 'a') % 26];
		}

		while (ch > 'z')
			ch -= 26;

		return ch;
	}
}