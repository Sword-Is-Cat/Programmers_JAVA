package level0.ex옷가게할인받기;

class Solution {
	public int solution(int price) {

		double rate = 1D;

		if (price >= 500000)
			rate = 0.8D;
		else if (price >= 300000)
			rate = 0.9D;
		else if (price >= 100000)
			rate = 0.95D;

		return (int) (price * rate);
	}
}