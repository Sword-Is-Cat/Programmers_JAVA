package level4.ex숫자블록;

class Solution {
	long MAX = 10000000;

	public int[] solution(long begin, long end) {
		long[] res = new long[(int) (end - begin + 1)];
		boolean[] changed = new boolean[res.length];
		for (int i = 0; i < res.length; ++i) {
			res[i] = begin + (long) i;
		}

		long max = (Double.valueOf(Math.sqrt(end))).longValue();
		for (long i = 2; i <= Math.min(max, MAX); ++i) {
			long start;
			if (begin % i == 0)
				start = begin;
			else
				start = (begin / i) * i + i;
			for (long n = start; n <= end; n += i) {
				int idx = (int) (n - begin);
				if (changed[idx])
					continue;
				if (n / i > MAX)
					break;
				res[idx] = n / i;
				changed[idx] = true;
			}
		}
		int[] tmp = new int[res.length];
		for (int i = 0; i < res.length; ++i) {
			if (!changed[i])
				res[i] = 1;
			tmp[i] = (int) res[i];
		}
		if (begin == 1)
			tmp[0] = 0;
		return tmp;
	}
}