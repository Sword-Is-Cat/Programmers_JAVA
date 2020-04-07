package level2.ex조이스틱;

class Solution {
	public int solution(String name) {

		char[] arr = name.toCharArray();
		int answer = 0;

		for (char ch : arr) {
			int move = Math.min(ch - 'A', 'A' - ch + 26);
			answer += move;
		}

		int min = 0;
		// case1 전진만 하는경우
		char[] arrr = arr.clone();
		for (int i = 0; i < arr.length; i++) {
			arrr[i] = 'A';
			if (check(arrr)) {
				min = i;
				break;
			}
		}

		// case2 후진도 하는경우(첫번째 위치에서 왼쪽으로 이동하여 마지막문자로 이동)
		for (int i = 0; i * 2 < arr.length - 1; i++) {
			arrr = arr.clone();
			for (int j = 0; j <= i; j++) {
				arrr[j] = 'A';
			}
			for (int j = 1; j < arr.length - (i * 2) - 1; j++) {
				arrr[arr.length - j] = 'A';
				if (check(arrr))
					min = (min > 2 * i + j) ? 2 * i + j : min;
			}
		}
		return answer+min;
	}

	public boolean check(char[] arr) {

		for (char ch : arr) {
			if (ch != 'A')
				return false;
		}
		return true;
	}

}