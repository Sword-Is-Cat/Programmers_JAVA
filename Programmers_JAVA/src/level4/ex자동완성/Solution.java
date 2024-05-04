package level4.ex자동완성;

class Solution {
	public int solution(String[] words) {
		Trie root = new Trie();

		for (String word : words) {
			root.addWord(word);
		}

		int answer = 0;

		for (String word : words) {
			answer += root.findLeastInput(word);
		}

		return answer;
	}
}

class Trie {
	private Trie[] child;
	private int count;
	private boolean isEnd;

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

	private int count() {
		if (count == 0) {
			count = isEnd ? 1 : 0;
			for (int i = 0; i < child.length; i++) {
				count += child[i] == null ? 0 : child[i].count();
			}
		}
		return count;
	}

	protected int findLeastInput(String str) {
		return findLeastInput(str, 0);
	}

	private int findLeastInput(String str, int index) {
		if (count() == 1 || str.length() == index)
			return index;
		return child[str.charAt(index) - 'a'].findLeastInput(str, index + 1);
	}
}