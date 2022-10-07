package level0.ex짝수홀수개수;

class Solution {
	public int[] solution(int[] num_list) {

		int cntEven = 0;
		for (int no : num_list)
			if (no % 2 == 0)
				cntEven++;

		return new int[] { cntEven, num_list.length - cntEven };
	}
}