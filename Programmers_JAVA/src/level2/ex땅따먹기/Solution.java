package level2.ex땅따먹기;

class Solution {
	int solution(int[][] land) {
		
		//land 배열을 해당 값이 아닌 룰에 따라 진행했을때의 결과값으로 치환한다
		
		for(int i = land.length-2 ; i>=0 ; i--) {
			//마지막행은 값 그 자체로 결과값이므로 처리 생략
			for(int j = 0 ; j<4 ; j++) {
				int process = 0;
				for(int k = 0 ; k<4 ; k++) {
					if(j == k)
						continue;
					else
						process = (process>land[i+1][k])?process:land[i+1][k];
				}
				land[i][j] += process;
			}
			//land[i][j] += land[i+1][] 값들중([i+1][j]제외) 최대값
			
		}
		
		int answer = 0;
	
		for(int i = 0 ; i<4 ; i++) {
			answer = (answer>land[0][i])?answer:land[0][i];
		}
		//치환된 land[0][]값들중의 최대값을 리턴한다
		
		return answer;
	}

}