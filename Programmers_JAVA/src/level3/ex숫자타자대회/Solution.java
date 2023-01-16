package level3.ex숫자타자대회;

class Solution {

	int[][] work = { 
			{ 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 }, 
			{ 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
			{ 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 }, 
			{ 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 }, 
			{ 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
			{ 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 }, 
			{ 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 }, 
			{ 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
			{ 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 }, 
			{ 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 } };

	public int solution(String numbers) {

		int[][] cache = new int[numbers.length()][10];

		// 처음 입력할 키
		int prev = (int) numbers.charAt(0) - 48;
		//System.out.println("입력키:" + prev);
		cache[0][6] = prev == 6 ? 0 : work[4][prev];
		cache[0][4] = prev == 4 ? 0 : work[6][prev];

		for (int i = 1; i < numbers.length(); i++) {

			int next = (int) numbers.charAt(i) - 48;
			//System.out.println("입력키:" + next);

			for (int posi = 0; posi < 10; posi++) {
				//System.out.println("as_is:[" + prev + "," + posi + "] -> " + cache[i - 1][posi]);

				// 손의 위치는 각각 prev, position에 있다
				if (cache[i - 1][posi] > 0) {
					// [1] prev가 움직이는 경우 -> 다음 손위치는 next, posi
					int movePrev = cache[i - 1][posi] + work[prev][next];
					if (next != posi) {
						cache[i][posi] = cache[i][posi] == 0 ? movePrev : (Math.min(cache[i][posi], movePrev));
						//System.out.println("> to_be:[" + next + "," + posi + "] -> " + cache[i][posi]);
					}
					// [2] position이 움직이는 경우 -> 다음 손위치는 prev, next
					int movePosi = cache[i - 1][posi] + work[posi][next];
					if (next != prev) {
						cache[i][prev] = cache[i][prev] == 0 ? movePosi : (Math.min(cache[i][prev], movePosi));
						//System.out.println("> to_be:[" + prev + "," + next + "] -> " + cache[i][prev]);
					}
				}
			}
			prev = next;
		}

		int answer = Integer.MAX_VALUE;

		for (int val : cache[numbers.length() - 1]) {
			if (val > 0)
				answer = Math.min(answer, val);
		}

		return answer;
	}
}