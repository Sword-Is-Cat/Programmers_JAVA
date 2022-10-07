package level0.exN의배수고르기;

import java.util.ArrayList;

class Solution {
	public int[] solution(int n, int[] numlist) {

		ArrayList<Integer> list = new ArrayList<>();

		for (int num : numlist)
			if (num % n == 0)
				list.add(num);

		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = list.get(i);
		
		return answer;
	}
}