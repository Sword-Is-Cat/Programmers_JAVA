package level4.ex숫자블록;

class Solution {
	public int[] solution(long begin, long end) {

		int length = (int) (end - begin + 1);
		int[] answer = new int[length];

		for (int i = 0; i < answer.length; i++)
			answer[i] = calc(i + begin);

		return answer;
	}

	public int calc(long index) {

		if (index == 1)
			return 0;

		for (long i = 2; i * i <= index; i++)
			if (index % i == 0) {
				if (index / i <= 10000000)
					return (int) (index / i);
				else
					continue;
			}
		return 1;
	}
}