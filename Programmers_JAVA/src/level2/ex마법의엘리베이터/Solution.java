package level2.ex마법의엘리베이터;

class Solution {
	public int solution(int storey) {

		// 한자리수 층인경우 단순비교
		if (storey < 10)
			return Math.min(storey, 11 - storey);

		// n*10층에서의 이동은 n층에서의 이동과 동일
		if (storey % 10 == 0)
			return solution(storey / 10);

		int mod = storey % 10;

		// 10의 배수 층이 될때까지 한층씩 올라간 후 내려가기
		// vs 10의배수 층이 될때까지 한층씩 내려간 후 내려가기
		int wayUp = 10 - mod + solution(storey + 10 - mod);
		int wayDown = mod + solution(storey - mod);

		return Math.min(wayUp, wayDown);
	}
}