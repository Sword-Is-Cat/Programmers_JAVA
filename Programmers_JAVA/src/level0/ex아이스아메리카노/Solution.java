package level0.ex아이스아메리카노;

class Solution {

	final int COST = 5500;

	public int[] solution(int money) {
		return new int[] { money / COST, money % COST };
	}
}