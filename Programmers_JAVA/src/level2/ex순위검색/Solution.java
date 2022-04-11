package level2.ex순위검색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

	Map<String, Integer> dictionary;

	public int[] solution(String[] info, String[] query) {

		dictionaryBuild();

		Map<Integer, List<Integer>> applys = new HashMap<>();

		for (String inform : info) {
			int[] parseInfo = parseStr(inform);

			if (!applys.containsKey(parseInfo[0]))
				applys.put(parseInfo[0], new ArrayList<>());

			applys.get(parseInfo[0]).add(parseInfo[1]);
		}

		for (int key : applys.keySet()) {
			Collections.sort(applys.get(key), Collections.reverseOrder());
		}

		int[] answer = new int[query.length];

		for (int i = 0; i < query.length; i++) {

			int[] row = parseStr(query[i]);

			for (int key : applys.keySet()) {

				if (key % row[0] == 0) {

					List<Integer> list = applys.get(key);

					int left = -1, right = list.size();

					while (left + 1 < right) {
						int mid = (left + right) / 2;
						if (list.get(mid) >= row[1])
							left = mid;
						else
							right = mid;
					}

					answer[i] += left + 1;

				}

			}

		}
		return answer;
	}

	int[] parseStr(String str) {

		int[] result = { 1, 0 };

		str = str.replace(" and ", " ");

		String[] arr = str.split(" ");

		result[0] *= dictionary.get(arr[0]);
		result[0] *= dictionary.get(arr[1]);
		result[0] *= dictionary.get(arr[2]);
		result[0] *= dictionary.get(arr[3]);

		result[1] = Integer.parseInt(arr[4]);

		return result;

	}

	void dictionaryBuild() {

		dictionary = new HashMap<>();

		dictionary.put("cpp", 2);
		dictionary.put("java", 3);
		dictionary.put("python", 5);

		dictionary.put("backend", 7);
		dictionary.put("frontend", 11);

		dictionary.put("junior", 13);
		dictionary.put("senior", 17);

		dictionary.put("chicken", 19);
		dictionary.put("pizza", 23);

		dictionary.put("-", 1);
	}
}