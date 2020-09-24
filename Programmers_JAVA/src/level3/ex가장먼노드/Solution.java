package level3.ex가장먼노드;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public int solution(int n, int[][] edge) {

    	Node[] arr = new Node[n+1];
    	
    	for(int i = 1;i<arr.length;i++)
    		arr[i] = new Node();
    	
    	for(int[] connect : edge) {
    		arr[connect[0]].set.add(connect[1]);
    		arr[connect[1]].set.add(connect[0]);
    	}
    	
    	Set<Integer> all = new HashSet<>();
    	Set<Integer> set = new HashSet<>();
    	Set<Integer> temp = new HashSet<>();
    	
    	all.add(1);
    	temp.add(1);
    	
    	while(temp.size()>0) {
    		
    		set = temp;
    		temp = new HashSet<>();
    		
    		for(int i : set) {
    			for(int j : arr[i].set) {
    				if(all.add(j))
    					temp.add(j);
    			}
    		}
    	}
    		
    	
        return set.size();
    }
}

class Node{
	Set<Integer> set = new HashSet<>();
}