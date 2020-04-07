package level2.ex가장큰수;

/*
 * 문제 설명
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 */

import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public String solution(int[] numbers) {

		StringBuilder sb = new StringBuilder();

		String[] arr = new String[numbers.length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.toString(numbers[i]);
		}

		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {

				int s1 = Integer.parseInt(str1 + str2);
				int s2 = Integer.parseInt(str2 + str1);

				if (s1 > s2)
					return -1;
				else if (s1 < s2)
					return 1;
				else
					return 0;
			}
		});

		for (String str : arr) {
			if (!(sb.length() == 0 && str.equals("0")))
				sb.append(str);
		}

		if (sb.length() == 0)
			return "0";

		return sb.toString();
	}
}

class Solution2 {
	public String solution(int[] numbers) {

		No[] noArr = new No[numbers.length];
		for (int i = 0; i < noArr.length; i++) {
			noArr[i] = new No(numbers[i]);
		}

		Arrays.sort(noArr, new Comparator<No>() {
			public int compare(No no1, No no2) {
				if (no1.init1 != no2.init1) {
					return Integer.compare(no2.init1, no1.init1);
				} else if (no1.init2 != no2.init2) {
					return Integer.compare(no2.init2, no1.init2);
				} else if (no1.init3 != no2.init3) {
					return Integer.compare(no2.init3, no1.init3);
				} else if (no1.init1 > no1.init2) {
					return Integer.compare(no2.num, no1.num);
				} else {
					return Integer.compare(no1.num, no2.num);
				}
			}
		});

		StringBuilder sb = new StringBuilder();

		for (No no : noArr) {
			sb.append(no.num);
		}

		if (sb.substring(0, 1).equals("0"))
			return "0";
		else
			return sb.toString();
	}
}

class No { // Compare를 위한 변수를 가진 Class선언

	int init1;
	int init2;
	int init3;
	int num;

	No(int num) {

		this.num = num;

		if (num == 0) {
			init1 = -1;
		} else if (num < 10) {
			init1 = num;
			init2 = init1;
			init3 = init1;
		} else if (num < 100) {
			init1 = num / 10;
			init2 = num % 10;
			init3 = init1;
		} else if (num < 1000) {
			init1 = num / 100;
			init2 = (num % 100) / 10;
			init3 = num % 10;
		} else {
			init1 = 0;
		}

	}

}

/////////////////////////////////
/*
테스트 1 〉	통과 (73.97ms, 55.8MB)
테스트 2 〉	통과 (45.48ms, 59.1MB)
테스트 3 〉	통과 (92.05ms, 65.3MB)
테스트 4 〉	통과 (7.17ms, 52.7MB)
테스트 5 〉	통과 (76.24ms, 61.3MB)
테스트 6 〉	통과 (54.94ms, 61.8MB)
테스트 7 〉	통과 (1.20ms, 45.1MB)
테스트 8 〉	통과 (1.21ms, 45.1MB)
테스트 9 〉	통과 (1.11ms, 52.2MB)
테스트 10 〉	통과 (1.20ms, 50.5MB)
테스트 11 〉	통과 (1.26ms, 45.5MB)
*/