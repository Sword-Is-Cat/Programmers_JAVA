package level0.ex개미군단;

class Solution {
	public int solution(int hp) {
		int answer = 0;

		answer += hp / 5;
		hp %= 5;

		if (hp > 2)
			hp -= 2;

		return answer + hp;
	}
}