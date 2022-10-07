package level0.ex숫자찾기;

class Solution {
	public int solution(int num, int k) {

		int position = Integer.toString(num).indexOf(Integer.toString(k));

		return position < 0 ? position : position + 1;
	}
}