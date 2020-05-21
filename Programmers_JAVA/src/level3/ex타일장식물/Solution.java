package level3.ex타일장식물;

class Solution {
	public long solution(int N) {

		long[] fibonacci = new long[N + 1];
		fibonacci[0] = 0;
		fibonacci[1] = 1;

		if (N > 1)
			for (int i = 2; i <= N; i++) {
				fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
			}

		return fibonacci[N] * 4 + fibonacci[N - 1] * 2;
	}
}