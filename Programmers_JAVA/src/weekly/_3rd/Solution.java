package weekly._3rd;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/84325
 */

import java.util.HashMap;
import java.util.Map;

class Solution {

	public String solution(String[] table, String[] languages, int[] preference) {

		/*
		 * String배열로 주어진 table을 호출하기 용이하도록 Map의 형태로 변환
		 * tableMap.get(직군명).get(언어명) = 직업군언어점수
		 */

		Map<String, Map<String, Integer>> tableMap = new HashMap<>();

		for (int tableIndex = 0; tableIndex < table.length; tableIndex++) {

			String[] scoreArr = table[tableIndex].split(" ");

			Map<String, Integer> scoreMap = new HashMap<>();

			scoreMap.put(scoreArr[1], 5);
			scoreMap.put(scoreArr[2], 4);
			scoreMap.put(scoreArr[3], 3);
			scoreMap.put(scoreArr[4], 2);
			scoreMap.put(scoreArr[5], 1);

			tableMap.put(scoreArr[0], scoreMap);

		}
		// !table to tableMap

		String answer = "";
		int max = Integer.MIN_VALUE;

		/*
		 * 각 직군별로 직군별언어점수x언어선호도의 점수 산출하여 최대값을 caching한다
		 */

		for (String job : tableMap.keySet()) {

			Map<String, Integer> scoreMap = tableMap.get(job);

			int tempScore = 0;

			for (int langIndex = 0; langIndex < languages.length; langIndex++) {

				String lang = languages[langIndex];
				int prefer = preference[langIndex];

				if (scoreMap.containsKey(lang)) {
					tempScore += scoreMap.get(lang) * prefer;
				}

			}

			// caching

			if (max < tempScore) {
				answer = job;
				max = tempScore;
			} else if (max == tempScore) {
				answer = answer.compareTo(job) < 0 ? answer : job;
			}
			/*
			System.out.println("##################################");
			System.out.println("compare > " + job + " : " + tempScore);
			System.out.println("result  > " + answer + " : " + max);
			 */
			// !caching

		}

		return answer;

	}

}