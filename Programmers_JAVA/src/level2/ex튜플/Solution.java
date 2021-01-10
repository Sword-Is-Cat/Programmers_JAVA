package level2.ex튜플;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

	public int[] solution(String s) {

		// 변수로 받은 s를 튜플string의 배열로 변환한다 strArr = {"2", "2,1", "2,1,3", "2,1,3,4"}
		String[] strArr = s.substring(2, s.length() - 2).split("\\},\\{");

		// strArr배열을 원소의 length순으로 정렬
		Arrays.sort(strArr, (a, b) -> {
			return a.length() - b.length();
		});

		int[] answer = new int[strArr.length];

		Set<String> set = new HashSet<>();

		/*
		 * strArr의 각 원소들을 ","로 split하여 set에 담는다 새 원소가 확인되면(set.add(str)==true) 해당 str을
		 * int로 변환하여 배열에 저장
		 */
		for (int i = 0; i < strArr.length; i++) {

			String[] arr = strArr[i].split(",");

			for (String str : arr) {
				if (set.add(str)) {
					answer[i] = Integer.parseInt(str);
					break;
				}
			}
		}

		return answer;
	}
}