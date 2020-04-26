package level1.ex소수찾기;


//return quantity of prime number(1~n)
class Solution {
	public int solution(int n) {

		int answer = 0;

		boolean[] list = new boolean[n - 1];

		for (int i = 0; i < n - 1; i++) {

			list[i] = true;

		}

		for (int i = 2; i * i <= n; i++) {

			if (list[i - 2]) {

				for (int j = i; i * j <= n; j++) {

					if (list[i * j - 2]) {

						list[i * j - 2] = false;

					}

				}
			}

		}

		for (boolean flag : list) {

			if (flag)
				answer++;
		}

		return answer;

	}

//	public static void main(String[] args) {
//		
//		long start = System.currentTimeMillis();
//		Solution s = new Solution();
//		System.out.println(s.solution(1000000));
//		long end = System.currentTimeMillis();
//		
//		System.out.println(end-start);
//		
//	}

}