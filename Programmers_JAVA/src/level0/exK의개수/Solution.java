package level0.exK의개수;

class Solution {
	public int solution(int i, int j, int k) {

		int answer = 0;

		for (int no = i; no <= j; no++) {

			int num = no;

			while (num > 0) {
				if (num % 10 == k)
					answer++;
				num /= 10;
			}

		}

		return answer;
	}
}