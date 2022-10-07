package level0.ex세균증식;

class Solution {
	public int solution(int n, int t) {

		return t == 0 ? n : solution(n * 2, t - 1);
	}
}