package level0.ex공던지기;

class Solution {
	public int solution(int[] numbers, int k) {
		return numbers[(2 * (k - 1)) % numbers.length];
	}
}