package level0.ex가까운수;

class Solution {
	public int solution(int[] array, int n) {

		int num = 1, diff = Integer.MAX_VALUE;

		for (int no : array) {

			int newDif = Math.abs(no - n);

			if (diff > newDif) {

				diff = newDif;
				num = no;

			} else if (diff == newDif)
				num = Math.min(num, no);

		}

		return num;
	}
}