package level2.exž;

class Solution {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        for(int i = 0 ; i<heights.length ; i++) {
        	for(int j = i ; j>=0 ; j--) {
        		if(heights[j] > heights[i]) {
        			answer[i] = j+1;
        			break;
        		}
        	}
        }
        return answer;
    }
}