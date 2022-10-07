package level0.ex구슬을나누는경우의수;

class Solution {
	public long solution(int balls, int share) {
		return share == 0 ? 1L : solution(balls - 1, share - 1) * balls / share;
	}
}