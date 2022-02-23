package level2.ex캐시;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
    	
    	Queue<String> que = new LinkedList<>();
    	int answer = 0;
    	
    	for(String city : cities) {
    		
    		city = city.toUpperCase();
    		
    		if(que.contains(city)) {
    			answer += 1;
    			que.remove(city);
    			que.add(city);
    		}else {
    			answer += 5;
    			que.add(city);
    		}
    		
    		while(que.size()>cacheSize)
    			que.poll();
    		
    	}
    	
        return answer;
    }
}