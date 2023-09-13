package level3.ex불량사용자;

import java.util.ArrayList;
import java.util.HashSet;

class Solution {

	ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	String[] users, bans;

	public int solution(String[] user_id, String[] banned_id) {

		users = user_id;
		bans = banned_id;

		for (int i = 0; i < banned_id.length; i++)
			graph.add(new ArrayList<>());

		for (int ban = 0; ban < banned_id.length; ban++) {
			for (int user = 0; user < user_id.length; user++) {
				if (match(user_id[user], banned_id[ban]))
					graph.get(ban).add(user);
			}
		}

		dfs(new boolean[users.length], 0);

		return checker.size();
	}

	HashSet<Integer> checker = new HashSet<>();

	private void dfs(boolean[] ban, int idx) {

		if (idx == bans.length) {
			checker.add(parseBooleans(ban));
			return;
		}

		for (int user : graph.get(idx)) {
			if (!ban[user]) {
				ban[user] = true;
				dfs(ban, idx + 1);
				ban[user] = false;
			}
		}

	}

	private int parseBooleans(boolean[] arr) {
		int rst = 0;

		for (int i = 0; i < arr.length; i++) {
			rst *= 2;
			rst += arr[i] ? 1 : 0;
		}

		return rst;
	}

	private boolean match(String origin, String pattern) {

		if (origin.length() != pattern.length())
			return false;

		for (int i = 0; i < origin.length(); i++) {
			if (pattern.charAt(i) != '*' && pattern.charAt(i) != origin.charAt(i))
				return false;
		}

		return true;
	}
}