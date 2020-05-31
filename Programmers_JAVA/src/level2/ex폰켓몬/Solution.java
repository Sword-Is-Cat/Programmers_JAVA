package level2.ex폰켓몬;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
    	
    	Set<Integer> set = new HashSet<>();
    	
    	for(int i : nums)
    		set.add(i);
    	
        return Math.min(set.size(), nums.length/2);
    }
}