package level4.ex가사검색;

import java.util.HashMap;

class Solution {
	public int[] solution(String[] words, String[] queries) {

		// key: str length, value: [opposite_root, reverse_root]
		HashMap<Integer, Trie[]> map = new HashMap<>();

		for (String word : words) {
			map.putIfAbsent(word.length(), new Trie[] { new Trie(), new Trie() });
			map.get(word.length())[0].addWord(word);
			map.get(word.length())[1].addWord(reverse(word));
		}

		int[] answer = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			String query = queries[i];
			int length = query.length();

			if (!map.containsKey(length))
				answer[i] = 0;
			else {
				if (query.charAt(0) == '?') {
					answer[i] = map.get(length)[1].findPattern(reverse(query));
				} else {
					answer[i] = map.get(length)[0].findPattern(query);
				}
			}

		}

		return answer;
	}

	protected String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}

}

class Trie {

	private Trie[] child;
	private boolean isEnd;
	private int cnt;

	Trie() {
		child = new Trie[26];
	}

	protected void addWord(String str) {
		addWord(str, 0);
	}

	private void addWord(String str, int index) {
		if (index == str.length()) {
			isEnd = true;
		} else {
			int idx = str.charAt(index) - 'a';
			if (child[idx] == null)
				child[idx] = new Trie();
			child[idx].addWord(str, index + 1);
		}
	}

	protected int findPattern(String str) {
		return findPattern(str, 0);
	}

	private int findPattern(String str, int index) {

		char key = str.charAt(index);

		if (key == '?') {
			return cntAll();
		}
		return child[key - 'a'] != null ? child[key - 'a'].findPattern(str, index + 1) : 0;
	}

	private int cntAll() {
		if (cnt == 0) {
			cnt = isEnd ? 1 : 0;
			for (int i = 0; i < child.length; i++) {
				cnt += child[i] != null ? child[i].cntAll() : 0;
			}
		}
		return cnt;
	}
}