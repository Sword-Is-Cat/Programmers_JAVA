package level3.ex입국심사;

class Solution {
	public long solution(int n, int[] times) {

		long head = 0L;
		long tail = 1000000000000000000L;
		long mid = 0L;

		long cnt = 0;

		while (tail - head > 1) {

			mid = (head + tail) / 2;

			cnt = 0;

			for (int time : times) {
				cnt += mid / time;
				if (cnt < 0) {
					tail = mid;
					continue;
				}

			}

			if (cnt < n)
				head = mid;
			else
				tail = mid;

		}

		return tail;
	}

}