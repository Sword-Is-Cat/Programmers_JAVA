package weekly._8th;

import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
    	
    	/**
    	 * 가로/세로 관계없이 긴쪽/짧은 쪽으로 구분하여
    	 * 긴쪽의 최대값 * 짧은쪽의 최대값을 구한다
    	 */
    	
    	int longMax = 0, shortMax = 0;
    	
    	for(int[] array : sizes) {
    		
    		Arrays.sort(array);
    		
    		longMax = Math.max(longMax, array[1]);
    		shortMax = Math.max(shortMax, array[0]);
    		
    	}
    	
        return longMax * shortMax;
    }
}