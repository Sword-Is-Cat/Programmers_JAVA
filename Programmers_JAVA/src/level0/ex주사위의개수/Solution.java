package level0.ex주사위의개수;

class Solution {
	public int solution(int[] box, int n) {
		return (box[0] / n) * (box[1] / n) * (box[2] / n);
	}
}