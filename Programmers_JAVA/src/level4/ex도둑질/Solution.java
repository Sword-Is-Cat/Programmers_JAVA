package level4.ex도둑질;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42897
 */

class Solution {
	public int solution(int[] money) {

		int length = money.length;

		if (length == 3) {
			return Math.max(Math.max(money[0], money[1]), money[2]);
		}

		int[] case1 = new int[length];

		case1[0] = money[0];
		case1[1] = 0;
		case1[2] = money[0] + money[2];

		for (int i = 3; i < length - 1; i++) {
			case1[i] = money[i] + Math.max(case1[i - 3], case1[i - 2]);
		}

		int[] case2 = new int[length];

		case2[0] = 0;
		case2[1] = money[1];
		case2[2] = Math.max(money[1], money[2]);

		for (int i = 3; i < length; i++) {
			case2[i] = money[i] + Math.max(case2[i - 3], case2[i - 2]);
		}

		return Math.max(Math.max(case1[length - 3], case1[length - 2]), Math.max(case2[length - 2], case2[length - 1]));
	}
}