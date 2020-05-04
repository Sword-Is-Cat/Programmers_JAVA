package level2.ex위장;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
    	
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        //Map<부위, 경우의수(안입은것 포함)> 선언
        
        for(int i = 0 ; i<clothes.length ; i++) {
        	
        	if(map.containsKey(clothes[i][1])) {
        		
        		map.replace(clothes[i][1], map.get(clothes[i][1])+1);
        	}else {
        		
        		map.put(clothes[i][1], 2);
        	}
        }
        //모든 옷에 대해 부위를 구분하여 수량 count작업
        //입지 않는 경우의 수를 포함하므로 처음 put시 value는 2로 들어간다.(안입은것, 입은것)
        
        for(Integer i : map.values()) {
        	
        	answer *= i;
        }
        //모든 경우의수(옷의 가짓수의 곱) 계산
        
        return answer-1;
        //아무것도 안입은 1개의 경우 제외하고 return
    }
}