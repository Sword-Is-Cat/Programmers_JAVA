package level2.ex유사칸토어비트열;

public class Solution {

	public int solution(int n, long l, long r) {
		return countOneToIndex(r) - countOneToIndex(l - 1);
	}

	private int countOneToIndex(long index) {
		if (index == 0 || index == 1)
			return (int) index;
		long share = index / 5;
		int remain = (int) (index % 5);
		if (remain > 2)
			remain--;
		return 4 * countOneToIndex(share) + remain * numberAtIndex(share + 1);
	}

	private int numberAtIndex(long index) {
		if (index == 1)
			return 1;
		if (index % 5 == 3)
			return 0;
		return numberAtIndex((index + 4) / 5);
	}
}