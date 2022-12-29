package level1.ex크기가작은부분문자열;

class Solution {

	char[] tArr, pArr;

	public int solution(String t, String p) {

		tArr = t.toCharArray();
		pArr = p.toCharArray();

		int ans = 0;

		for (int idx = 0; idx + pArr.length <= tArr.length; idx++) {
			if (query(idx))
				ans++;
		}
		return ans;
	}

	boolean query(int index) {
		for (int i = 0; i < pArr.length; i++) {
			if (tArr[index + i] > pArr[i])
				return false;
			if (tArr[index + i] < pArr[i])
				break;
		}
		return true;
	}
}