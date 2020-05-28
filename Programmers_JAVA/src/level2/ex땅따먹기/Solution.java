package level2.ex땅따먹기;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12913
 */

class Solution {
	int solution(int[][] land) {
		/*
		land 배열을 해당 칸에서 시작했을때의 최대값으로 치환한다
		land[0]이 아닌 land[length-2]부터 처리시작
		*/
		for(int i = land.length-2 ; i>=0 ; i--) {
			//마지막행은 값 그 자체로 결과값이므로 처리 생략
			for(int j = 0 ; j<4 ; j++) {
				int proc = 0;
				for(int k = 0 ; k<4 ; k++) {
					if(j == k)
						continue;
					else
						proc = Math.max(process,land[i+1][k]);
				}
				land[i][j] += proc;
			}
			//land[i][j] += land[i+1][] 값들중([i+1][j]제외) 최대값			
		}		
		int answer = Math.max(Math.max(land[0][0], land[0][1]), Math.max(land[0][2], land[0][3]));
		//치환된 land[0][]값들중의 최대값을 리턴한다		
		return answer;
	}
}
