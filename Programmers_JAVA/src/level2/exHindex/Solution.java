package level2.exHindex;

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
    	
    	int answer = 0;
    	
    	Arrays.sort(citations);
    	
    	boolean flag = true;
    	
    	for(int i = 0 ; i<citations.length ; i++) {
    		
    		if(citations[citations.length-1-i]<i+1) {
    			answer = i;
    			flag = false;
    			break;
    		}
    	}
    	
    	if(flag)
    		answer = citations.length;
    	
        return answer;
    }
}