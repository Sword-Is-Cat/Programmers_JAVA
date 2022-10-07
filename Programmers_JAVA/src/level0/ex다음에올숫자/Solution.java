package level0.ex다음에올숫자;

class Solution {
	public int solution(int[] common) {

		if (common[1] * 2 == common[0] + common[2])
			return common[common.length - 1] + common[1] - common[0];

		return common[common.length - 1] * common[1] / common[0];
	}
}