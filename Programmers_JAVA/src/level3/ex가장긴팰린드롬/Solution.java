package level3.ex가장긴팰린드롬;

class Solution {

	char[] charArr;
	int length = 0;

	public int solution(String s) {

		charArr = s.toCharArray();
		
		for(int si = 0 ; si<charArr.length ; si++) {
			
			for(int leng = length ; si+leng<charArr.length ; leng++) {
				if(isPalindrome(si, si+leng))
					length = leng;
			}
			
		}

		return length + 1;
	}

	public boolean isPalindrome(int si, int ei) {

		int sum = si + ei;

		for (int i = si; i <= ei; i++) {
			if (charArr[i] != charArr[sum - i]) {
				return false;
			}
		}
		return true;
	}
	/*
	public static void main(String[] args) {
		System.out.println(new Solution().solution("abacde"));
	}
	*/

}