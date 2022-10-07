package level0.ex제곱수판별하기;

class Solution {
	public int solution(int n) {

		int sqrt = (int) Math.sqrt(n);

		return sqrt * sqrt == n ? 1 : 2;

	}
}