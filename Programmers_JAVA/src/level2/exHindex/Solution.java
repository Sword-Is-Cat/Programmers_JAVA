package level2.exHindex;

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
    	
    	int answer = citations.length;
    	
    	Arrays.sort(citations);
    	
    	for(int i = 0 ; i<citations.length ; i++) {
    		
    		if(citations[citations.length-1-i]<i+1) {
    			answer = i;
    			break;
    		}
    	}
    	
        return answer;
    }
}