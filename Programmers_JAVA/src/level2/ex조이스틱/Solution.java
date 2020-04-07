package level2.ex조이스틱;

/*
 * 문제 설명
조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

조이스틱을 각 방향으로 움직이면 아래와 같습니다.

▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동
예를 들어 아래의 방법으로 JAZ를 만들 수 있습니다.

- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

제한 사항
name은 알파벳 대문자로만 이루어져 있습니다.
name의 길이는 1 이상 20 이하입니다.
 */

import java.util.ArrayList;
import java.util.Collections;

class Solution {
	public int solution(String name) {

		char[] arr = name.toCharArray();
		int answer = 0;

		for (char ch : arr) {
			int move = Math.min(ch - 'A', 'A' - ch + 26);
			answer += move;
		}

		ArrayList<Integer> list = new ArrayList<>();

		// case1 전진만
		char[] arrr = arr.clone();
		for (int i = 0; i < arr.length; i++) {
			arrr[i] = 'A';
			if (check(arrr))
				list.add(i);
		}

		// case2 후진도
		for (int i = 0; i * 2 < arr.length - 1; i++) {
			arrr = arr.clone();
			for (int j = 0; j <= i; j++) {
				arrr[j] = 'A';
			}
			for (int j = 1; j < arr.length - (i * 2) - 1; j++) {
				arrr[arr.length - j] = 'A';
				if (check(arrr))
					list.add(2 * i + j);
			}
		}

		////////////////////////////

		Collections.sort(list);
		answer += list.get(0);

		return answer;
	}

	public boolean check(char[] arr) {

		for (char ch : arr) {
			if (ch != 'A')
				return false;
		}
		return true;
	}

}