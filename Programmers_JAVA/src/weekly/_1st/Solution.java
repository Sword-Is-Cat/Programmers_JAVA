package weekly._1st;

class Solution {
	public long solution(int price, int money, int count) {

		long answer = 0;

		long amp = count * (count + 1) / 2;
		long cost = amp * price;

		if (money < cost)
			answer = cost - money;

		return answer;
	}
}