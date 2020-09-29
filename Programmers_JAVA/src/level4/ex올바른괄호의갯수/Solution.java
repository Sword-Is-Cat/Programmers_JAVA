package level4.ex올바른괄호의갯수;

class Solution {
    public int solution(int n) {
        
    	return combination(2*n, n)-combination(2*n,n+1);
    }
    
    int combination(int a, int b) {
    	
    	long answer = 1;
    	b = Math.min(a-b, b);
    	
    	for(int i = 0 ; i<b ; i++)
    		answer = answer*(a-i)/(i+1);
    	
    	return (int)answer;
    }
}