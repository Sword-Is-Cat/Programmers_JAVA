package level0.ex중복된숫자개수;

class Solution {
	public int solution(int[] array, int n) {
		int cnt = 0;

		for (int no : array) {
			if (no == n)
				cnt++;
		}

		return cnt;
	}
}