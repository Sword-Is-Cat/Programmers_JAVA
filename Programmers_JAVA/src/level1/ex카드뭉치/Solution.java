package level1.ex카드뭉치;

class Solution {
	public String solution(String[] cards1, String[] cards2, String[] goal) {

		for (int idx = 0, i1 = 0, i2 = 0; idx < goal.length; idx++) {
			if (i1 < cards1.length && cards1[i1].equals(goal[idx]))
				i1++;
			else if (i2 < cards2.length && cards2[i2].equals(goal[idx]))
				i2++;
			else
				return "No";
		}
		return "Yes";
	}
}