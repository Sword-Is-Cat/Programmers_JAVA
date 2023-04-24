package level0.exFlag값에따라다른값반환하기;

class Solution {
	public int solution(int a, int b, boolean flag) {
		return flag ? (a + b) : (a - b);
	}
}