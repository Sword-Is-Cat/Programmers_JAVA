package level0.ex외계어사전;

class Solution {
	public int solution(String[] spell, String[] dic) {

		for (String word : dic) {

			if (word.length() == spell.length) {

				for (String cha : spell) {
					word = word.replaceFirst(cha, "");
				}

				if (word.length() == 0)
					return 1;
			}
		}

		return 2;
	}
}