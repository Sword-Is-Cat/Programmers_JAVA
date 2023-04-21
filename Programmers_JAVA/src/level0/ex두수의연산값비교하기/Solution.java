package level0.ex두수의연산값비교하기;

class Solution {
	public int solution(int a, int b) {
		return Math.max(Integer.parseInt("" + a + b), 2 * a * b);
	}
}