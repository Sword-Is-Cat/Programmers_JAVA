package level1.ex1차_다트게임;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/17682
 */

class Solution {
	public int solution(String dartResult) {
		int answer = 0;

		int[] score = new int[3];
		String[] bonus = new String[3];
		String[] option = new String[3];

		String[] scoreStr = dartResult.split("[^0-9]+");
		String[] boStr = dartResult.split("[0-9]+");

		for (int i = 0; i < 3; i++) {

			score[i] = Integer.parseInt(scoreStr[i]);

			if (boStr[i + 1].length() == 2) {
				bonus[i] = boStr[i + 1].substring(0, 1);
				option[i] = boStr[i + 1].substring(1);
			} else {
				bonus[i] = boStr[i + 1];
				option[i] = "";
			}

			switch (bonus[i]) {

			case "D":
				score[i] = score[i] * score[i];
				break;
			case "T":
				score[i] = score[i] * score[i] * score[i];
				break;
			default:

			}
			
			switch(option[i]) {
			case "#":
				score[i] = -score[i];
				break;
			case "*":
				score[i] = score[i]*2;
				if(i!=0)
					score[i-1] = score[i-1]*2;
				break;
			}
		}

		for(int i : score) {
			answer += i;
		}

		return answer;
	}

}