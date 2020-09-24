package level3.ex3xn타일링;

class Solution {
    public int solution(int n) {
    	
    	long[] dp = new long[n/2];
    	
    	dp[0] = 3;
    	dp[1] = 11;
    	
    	for(int i = 2 ; i<dp.length ; i++) {
    		dp[i] = dp[i-1]*4-dp[i-2];
    		dp[i] = dp[i]>0?dp[i]%1000000007:dp[i]+1000000007;
    	}
    	
        return (int)dp[dp.length-1];
    }
}