package level2.ex���̽�ƽ;

class Solution {
	public int solution(String name) {

		char[] arr = name.toCharArray();
		int answer = 0;

		for (char ch : arr) {
			int move = Math.min(ch - 'A', 'A' - ch + 26);
			answer += move;
		}

		int min = 0;
		// case1 ������ �ϴ°��
		char[] arrr = arr.clone();
		for (int i = 0; i < arr.length; i++) {
			arrr[i] = 'A';
			if (check(arrr)) {
				min = i;
				break;
			}
		}

		// case2 ������ �ϴ°��(ù��° ��ġ���� �������� �̵��Ͽ� ���������ڷ� �̵�)
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