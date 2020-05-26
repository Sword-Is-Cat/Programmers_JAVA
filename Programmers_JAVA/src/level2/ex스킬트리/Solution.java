package level2.ex스킬트리;

/*
https://programmers.co.kr/learn/courses/30/lessons/49993
*/

class Solution {
	public int solution(String skill, String[] skill_trees) {

		int answer = 0;
		char[] skillArr = skill.toCharArray();
		if (skillArr.length == 1) {
			return skill_trees.length;
		}
		for (String st : skill_trees) {
			char[] stArr = st.toCharArray();
			int[] transArr = new int[skillArr.length];
			for (int i = 0; i < stArr.length; i++) {
				for (int j = 0; j < skillArr.length; j++) {
					if (stArr[i] == skillArr[j]) {
						transArr[j] = stArr.length - i;
					}
				}
			}
			for (int i = 0; i < transArr.length - 1; i++) {
				if (transArr[i] < transArr[i + 1]) {
					break;
				}
				if (i == transArr.length - 2) {
					answer++;
				}
			}
		}
		return answer;
	}
}

/*
class Solution {
	public int solution(String skill, String[] skill_trees) {
        
        int answer = 0;
        
        for(String str : skill_trees){
            if(skill.indexOf(str.replaceAll("[^"+skill+"]",""))==0) answer++;
        }
        
        return answer;
    }
}
*/