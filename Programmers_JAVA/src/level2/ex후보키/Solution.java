package level2.ex후보키;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

	List<String> candi = new ArrayList<>();

	public int solution(String[][] relation) {

		int cntKeys = relation[0].length;
		boolean[] visit = new boolean[cntKeys];

		for (int i = 0; i < cntKeys; i++) {
			dfs(visit, 0, 0, i + 1, relation);
		}

		return candi.size();
	}

	public void dfs(boolean[] visit, int idx, int keyLength, int targetLength, String[][] relation) {

		if (keyLength == targetLength) {

			List<Integer> list = new ArrayList<>();

			String key = "";

			for (int i = 0; i < visit.length; i++) {
				if (visit[i]) {
					key += String.valueOf(i);
					list.add(i);
				}
			}

			Map<String, Integer> map = new HashMap<>();

			for (int i = 0; i < relation.length; i++) {
				String s = "";
				for (Integer j : list) {
					s += relation[i][j];
				}

				if (map.containsKey(s)) {
					return;
				} else {
					map.put(s, 0);
				}
			}

			for (String s : candi) {
				int count = 0;
				for (int i = 0; i < key.length(); i++) {
					String subS = String.valueOf(key.charAt(i));
					if (s.contains(subS))
						count++;
				}
				if (count == s.length())
					return;
			}
			candi.add(key);

			return;
		}

		for (int i = idx; i < visit.length; i++) {

			if (!visit[i]) {

				visit[i] = !visit[i];
				dfs(visit, i, keyLength + 1, targetLength, relation);
				visit[i] = !visit[i];
			}
		}
	}
}