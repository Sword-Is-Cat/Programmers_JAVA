package SkillCheck_level2.Q1;

class Solution {
	public int solution(int n, int a, int b) {
		int answer = 0;
		
		int temp = (a-1)^(b-1);
		
		while(temp>0) {
			temp /= 2;
			answer++;
		}

		return answer;
	}
}