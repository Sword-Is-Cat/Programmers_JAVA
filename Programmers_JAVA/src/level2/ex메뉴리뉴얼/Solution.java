package level2.ex메뉴리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
	public String[] solution(String[] orders, int[] course) {

		Map<Integer, Map<String, Integer>> map = new HashMap<>();
		for (int no : course)
			map.put(no, new HashMap<>());

		for (String order : orders) {
			char[] arr = order.toCharArray();
			Arrays.sort(arr);
			proc(new String(arr), 0, null, null, map);
		}

		List<String> list = new ArrayList<>();

		for (Integer key : map.keySet()) {

			Map<String, Integer> smallMap = map.get(key);
			int cnt = 0;
			for (String menu : smallMap.keySet()) {
				cnt = Math.max(cnt, smallMap.get(menu));
			}

			if (cnt > 1) {
				for (String menu : smallMap.keySet()) {
					if (smallMap.get(menu) == cnt)
						list.add(menu);
				}
			}

		}

		String[] answer = new String[list.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = list.get(i);

		Arrays.sort(answer);
		return answer;
	}

	void proc(String order, int index, StringBuilder sb, Set<String> set, Map<Integer, Map<String, Integer>> map) {

		// System.out.println(
		// "call proc [order:" + order + ", index:" + index + ", sb:" + (sb == null ? "": sb.toString()) + "]");

		if (sb == null)
			sb = new StringBuilder();

		if (set == null)
			set = new HashSet<>();

		if (map.containsKey(sb.length()) && set.add(sb.toString())) {
			//System.out.println("mark " + sb.toString());
			Map<String, Integer> tempMap = map.get(sb.length());
			String key = sb.toString();
			if (tempMap.containsKey(key))
				tempMap.put(key, tempMap.get(key) + 1);
			else
				tempMap.put(key, 1);
		}

		if (index < order.length()) {
			proc(order, index + 1, sb, set, map);
			sb.append(order.charAt(index));
			proc(order, index + 1, sb, set, map);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static void main(String[] args) {
		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		int[] course = { 2, 3, 4 };
		new Solution().solution(orders, course);
	}
}