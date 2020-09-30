package level4.ex4단고음;

class Solution {

	int answer = 0;

	public int solution(int n) {

		process(n, 0, 0);
		
		return answer;
	}

	void process(int n, int apply, int plus) {

		if (n < 1 || apply * 2 > plus || plus > 38)
			return;

		else if (n == 1) {
			if (apply * 2 == plus)
				answer++;
			return;

		} else if (n % 3 == 0)
			process(n / 3, apply + 1, plus);

		process(n - 1, apply, plus + 1);
	}
}