package level0.ex치킨쿠폰;

class Solution {
	public int solution(int chicken) {

		int service = 0;

		while (chicken > 9) {
			service += chicken / 10;
			chicken = chicken / 10 + chicken % 10;
		}

		return service;
	}
}