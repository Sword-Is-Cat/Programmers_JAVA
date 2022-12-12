package level3.ex입국심사;

class Solution {
	public long solution(int n, int[] times) {
		long head = 0L, tail = 1000000000000000000L, mid;
		while (tail - head > 1) {
			mid = (head + tail) / 2;
			long cnt = 0;
			for (int time : times) {
				cnt += mid / time;
			}
			if (cnt < n)
				head = mid;
			else
				tail = mid;
		}
		return tail;
	}

}