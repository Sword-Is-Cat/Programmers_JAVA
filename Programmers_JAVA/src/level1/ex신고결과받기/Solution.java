package level1.ex신고결과받기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

	public int[] solution(String[] id_list, String[] report, int k) {

		Map<String, Integer> nameToIndex = new HashMap<>();
		List<Set<Integer>> reported = new ArrayList<>();
		int[] answer = new int[id_list.length];

		for (int i = 0; i < id_list.length; i++) {
			nameToIndex.put(id_list[i], i);
			reported.add(new HashSet<>());
		}

		for (String reportRow : report) {
			String[] reportDetail = reportRow.split(" ");
			String reporter = reportDetail[0];
			String reportedOne = reportDetail[1];
			reported.get(nameToIndex.get(reportedOne)).add(nameToIndex.get(reporter));
		}

		for (int i = 0; i < reported.size(); i++) {
			Set<Integer> reporters = reported.get(i);
			if (reporters.size() >= k) {
				for (int rpt : reporters) {
					answer[rpt]++;
				}
			}
		}
		return answer;
	}
}