package level2.ex올바른괄호;

class Solution {
	boolean solution(String str) {
		int cntUnpair = 0;
		for (char ch : str.toCharArray()) {
			cntUnpair += ch == '(' ? 1 : -1;
			if (cntUnpair < 0) return false;
		}
		return cntUnpair == 0;
	}
}