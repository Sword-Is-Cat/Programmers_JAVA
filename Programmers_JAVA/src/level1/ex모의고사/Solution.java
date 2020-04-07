package level1.ex모의고사;

/*
 * 문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
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
