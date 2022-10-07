package level0.ex저주의숫자3;

class Solution {

	int cache = 0;

	public int solution(int n) {

		int answer = 0;

		while (n-- > 0)
			answer = next();

		return answer;
	}

	int next() {

		cache++;

		if (cache % 3 == 0)
			return next();

		int temp = cache;

		while (temp > 0) {
			if (temp % 10 == 3)
				return next();
			temp /= 10;
		}

		return cache;
	}
}