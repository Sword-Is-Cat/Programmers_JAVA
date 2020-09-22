package level3.ex풍선터트리기;

class Solution {
    public int solution(int[] a) {
    	
    	if(a.length<3)
    		return a.length;
    	
    	int[][]arr = new int[a.length][3];
    	
    	for(int i = 0 ; i<a.length ; i++)
    		arr[i][1] = a[i];
    	
    	int left = Integer.MAX_VALUE;
    	
    	for(int i = 0 ; i<a.length ; i++) {
    		if(left>a[i])
    			left = a[i];
    		arr[i][0] = left;
    	}
    	
    	int right = Integer.MAX_VALUE;
    	
    	for(int i = 0 ; i<a.length ; i++) {
    		if(right>a[a.length-1-i])
    			right = a[a.length-1-i];
    		arr[a.length-1-i][2] = right;
    	}
    	
    	int answer = 2;
    	
    	for(int i = 1;i<a.length-1 ; i++) {
    		if(arr[i][0]>=arr[i][1] || arr[i][1]<=arr[i][2]) {
    			answer++;
    		}
    	}
    	
    	return answer;
    }
}