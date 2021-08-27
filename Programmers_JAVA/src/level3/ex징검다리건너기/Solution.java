package level3.ex징검다리건너기;

class Solution {

	public int solution(int[] stones, int k) {

		int low = 0;
		int high = Integer.MAX_VALUE;
		int mid = -1;

		while (low + 1 < high) {

			mid = (low + high) / 2;
			if (can(stones, k, mid)) {
				low = mid;
			} else {
				high = mid;
			}

		}

		return low;
	}

	public boolean can(int[] stones, int k, int value) {

		int cnt = 0;

		for (int i = 0; i < stones.length; i++) {

			if (stones[i] < value)
				cnt++;
			else
				cnt = 0;

			if (cnt == k)
				return false;
		}

		return true;

	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		System.out.println(new Solution().solution(arr, 3));
	}

}