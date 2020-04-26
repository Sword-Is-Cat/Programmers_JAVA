package level1.ex모의고사;


/*
 * ���� ����
�����ڴ� ������ ������ ����� �ظ��Դϴ�. ������ ���ι��� ���ǰ�翡 ���� ������ ���� ������ �մϴ�. �����ڴ� 1�� �������� ������ �������� ������ ���� ����ϴ�.

1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1�� �������� ������ ���������� ������ ������� ���� �迭 answers�� �־����� ��, ���� ���� ������ ���� ����� �������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����
������ �ִ� 10,000 ������ �����Ǿ��ֽ��ϴ�.
������ ������ 1, 2, 3, 4, 5�� �ϳ��Դϴ�.
���� ���� ������ ���� ����� ������ ���, return�ϴ� ���� �������� �������ּ���.
 */

import java.util.ArrayList;

class Solution {
	public static int[] solution(int[] answers) {
		int[] answer = {};

		int score1 = 0;
		int score2 = 0;
		int score3 = 0;

		for (int i = 0; i < answers.length; i++) {

			if (answers[i] == i % 5 + 1)
				score1++;

			switch (i % 8) {

			case 1:
				if (answers[i] == 1)
					score2++;
				break;
			case 3:
				if (answers[i] == 3)
					score2++;
				break;
			case 5:
				if (answers[i] == 4)
					score2++;
				break;
			case 7:
				if (answers[i] == 5)
					score2++;
				break;
			default:
				if (answers[i] == 2)
					score2++;
				break;

			}

			switch (i % 10) {

			case 0:
			case 1:
				if (answers[i] == 3)
					score3++;
				break;
			case 2:
			case 3:
				if (answers[i] == 1)
					score3++;
				break;
			case 4:
			case 5:
				if (answers[i] == 2)
					score3++;
				break;
			case 6:
			case 7:
				if (answers[i] == 4)
					score3++;
				break;
			default:
				if (answers[i] == 5)
					score3++;
				break;

			}

		}
		
		int best = score1;
		if(best<score2)
			best = score2;
		if(best<score3)
			best = score3;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		if(best == score1)
			list.add(1);
		if(best == score2)
			list.add(2);
		if(best == score3)
			list.add(3);
		
		answer = new int[list.size()];
		
		for(int i = 0 ; i<list.size();i++) {
			
			answer[i] = list.get(i);
		}
		
//		System.out.println(score1);
//		System.out.println(score2);
//		System.out.println(score3);

		return answer;
	}
	
//	public static void main(String[] args) {
//		
//		int[] a = {1,2,3,4,5,1,2,3,4,5};
//		Solution.solution(a);
//		
//	}
}
