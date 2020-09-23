package level2.ex더맵게;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {
    	
    	Queue<Integer> queue = new PriorityQueue<Integer>();
    	int count = 0;
    	
    	for(int i : scoville)
    		queue.add(i);
    	
    	while(queue.size()>1 && queue.peek()<K) {
    		
    		queue.add(queue.poll()+queue.poll()*2);
    		count++;
    	}
    	
    	return queue.peek()<K?-1:count;
    }
}