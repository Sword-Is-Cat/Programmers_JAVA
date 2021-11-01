package level4.ex징검다리;

import java.util.Arrays;

class Solution {
	public int solution(int distance, int[] rocks, int n) {

		int[] interval = new int[rocks.length + 1];
		Arrays.sort(rocks);

		interval[0] = rocks[0];
		for (int i = 1; i < rocks.length; i++)
			interval[i] = rocks[i] - rocks[i - 1];
		interval[rocks.length] = distance - rocks[rocks.length - 1];

		int numOfLump = interval.length - n;

		int head = 0;
		int tail = distance;

		while (tail - head > 1) {

			int length = (head + tail) / 2;

			if (isPossible(interval, numOfLump, length))
				head = length;
			else
				tail = length;
		}

		return head;

	}

	public boolean isPossible(int[] interval, int num, int length) {

		int temp = 0;
		int cnt = 0;

		for (int val : interval) {

			temp += val;

			if (temp >= length) {
				temp = 0;
				cnt++;
			}
		}

		if (temp >= length)
			cnt++;

		return num <= cnt;
	}

	public static void main(String[] args) {
		int[] rocks = { 2, 8, 9, 10, 11, 12, 13 };
		System.out.println(new Solution().solution(18, rocks, 6) + " = 9?");
		int[] rocks2 = { 2, 14, 11, 21, 17 };
		System.out.println(new Solution().solution(25, rocks2, 2) + " = 4?");
	}
}
