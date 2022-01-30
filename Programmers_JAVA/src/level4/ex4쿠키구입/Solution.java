package level4.ex4쿠키구입;

class Solution {
	public int solution(int[] cookie) {
		
		int sum = 0;
		for (int val : cookie)
			sum += val;
		
		int tempSum = 0;
		int answer = 0;
		for(int val:cookie) {
			tempSum+=val;
			answer = proc(answer, tempSum, sum, cookie);
		}
		return answer;
	}

	public int proc(int answer, int tempSum, int sum, int[] cookie) {

		int leftSum = tempSum;
		int rightSum = sum - leftSum;
		
		int left = 0;
		int right = cookie.length-1;
		
		while(leftSum>answer && rightSum>answer) {
			if(leftSum>rightSum) {
				leftSum -= cookie[left++];
			}else if(leftSum<rightSum) {
				rightSum -= cookie[right--];
			}else if(leftSum==rightSum) {
				return Math.max(answer, leftSum);
			}
		}
		return answer;
	}
}