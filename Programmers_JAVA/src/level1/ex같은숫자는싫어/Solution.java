package level1.ex같은숫자는싫어;

/* https://programmers.co.kr/learn/courses/30/lessons/12906 */

import java.util.*;

public class Solution {
		public int[] solution(int []arr) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(arr[0]);
        
        for(int i = 1; i<arr.length ; i++) {
        	
        	if(arr[i-1] != arr[i])
        		list.add(arr[i]);
        }
        
        answer = new int[list.size()];
        
        for(int i = 0 ; i<list.size() ; i++) {
        	
        	answer[i] = list.get(i);
        }
        
        return answer;
	}
}