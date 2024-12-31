package level3.PCCP_202409_04;

import java.util.HashSet;

class Solution {

	int maxDigit = 0, mod = 0;

	public String[] solution(String[] expressions) {
		for (int i = 0; i < expressions.length; i++) {
			updateMaxDigit(expressions[i]);
		}

		int answerLength = 0, idx = 0;

		for (int i = 0; i < expressions.length; i++) {
			if (!expressions[i].contains("X")) {
				analyze(expressions[i]);
			} else {
				answerLength++;
			}
		}

		String[] answer = new String[answerLength];

		for (int i = 0; i < expressions.length; i++) {
			if (expressions[i].contains("X")) {
				answer[idx++] = solve(expressions[i]);
			}
		}

		return answer;
	}

	private void updateMaxDigit(String str) {
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if ('0' <= ch && ch <= '9') {
				maxDigit = Math.max(maxDigit, ch - '0');
			}
		}
	}

	private void analyze(String str) {
		String[] arr = str.split(" ");
		int[] left = new int[3], right = new int[3], mid = "+".equals(arr[1]) ? left : right;
		String temp;

		temp = padLeft(arr[0]);
		left[0] += temp.charAt(0) - '0';
		left[1] += temp.charAt(1) - '0';
		left[2] += temp.charAt(2) - '0';

		temp = padLeft(arr[2]);
		mid[0] += temp.charAt(0) - '0';
		mid[1] += temp.charAt(1) - '0';
		mid[2] += temp.charAt(2) - '0';

		temp = padLeft(arr[4]);
		right[0] += temp.charAt(0) - '0';
		right[1] += temp.charAt(1) - '0';
		right[2] += temp.charAt(2) - '0';

		right[0] -= left[0];
		right[1] -= left[1];
		right[2] -= left[2];

		if (right[0] == 0) {
			if (right[1] != 0) {
				mod = -right[2] / right[1];
			}
		} else {
			for (int i = maxDigit + 1; i < 10; i++) {
				if ((-right[1] - i) * i == right[2]) {
					mod = i;
					return;
				}
			}
		}

	}

	private String solve(String str) {

		String[] arr = str.split(" ");
		int stt = mod == 0 ? maxDigit + 1 : mod, end = mod == 0 ? 9 : mod;
		HashSet<String> set = new HashSet<>();
		for (int m = stt; m <= end; m++) {
			int rst = 0;
			if ("+".equals(arr[1])) {
				rst = strToNum(arr[0], m) + strToNum(arr[2], m);
			} else {
				rst = strToNum(arr[0], m) - strToNum(arr[2], m);
			}
			set.add(numToStr(rst, m));
		}

		return str.replace("X", set.size() > 1 ? "?" : set.iterator().next());
	}

	private String padLeft(String str) {
		str = "00" + str;
		return str.substring(str.length() - 3);
	}

	private int strToNum(String str, int mod) {
		int rst = 0;
		for (int i = 0; i < str.length(); i++) {
			rst *= mod;
			rst += str.charAt(i) - '0';
		}
		return rst;
	}

	private String numToStr(int num, int mod) {
		StringBuilder sb = new StringBuilder();
		do {
			sb.append(num % mod);
			num /= mod;
		} while (num > 0);
		return sb.reverse().toString();
	}

}