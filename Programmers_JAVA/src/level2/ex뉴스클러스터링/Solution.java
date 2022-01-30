package level2.ex뉴스클러스터링;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int solution(String str1, String str2) {

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		Map<String, Integer> map1 = wordCounter(str1);
		Map<String, Integer> map2 = wordCounter(str2);

		int sum = map1.get("total") + map2.get("total");
		int cntIntersection = 0;

		for (String key : map1.keySet()) {
			if (!key.equals("total") && map2.containsKey(key)) {
				cntIntersection += Math.min(map1.get(key), map2.get(key));
			}
		}

		double similarity;

		if (sum == 0)
			similarity = 1D;
		else
			similarity = (double) cntIntersection / (sum - cntIntersection);

		return (int) (similarity * 65536);
	}

	public Map<String, Integer> wordCounter(String str) {

		Map<String, Integer> map = new HashMap<>();

		char[] arr = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		int cnt = 0;

		for (int i = 1; i < arr.length; i++) {

			sb.delete(0, sb.length());
			char prev = arr[i - 1];
			char curr = arr[i];

			if (prev >= 'a' && prev <= 'z' && curr >= 'a' && curr <= 'z') {
				String key = sb.append(prev).append(curr).toString();
				map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
				cnt++;
			}
		}

		map.put("total", cnt);

		return map;

	}
}