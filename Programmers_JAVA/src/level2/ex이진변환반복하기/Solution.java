package level2.ex이진변환반복하기;

class Solution {
	
	int changeCnt = 0;
	int removeZero = 0;
	
	public int[] solution(String s) {
		
		while(s.length()>1) {
			s = conBinary(s);
			changeCnt++;
		}
		
		int[] answer = {changeCnt, removeZero};
		return answer;
	}
	
	public String conBinary(String original) {
		
		//0제거한 str의 길이
		int conLength = original.replace("0", "").length();
		
		//감소한길이 = 제거된 0의 갯수
		int lengthDecrease = original.length() - conLength;

		removeZero += lengthDecrease;
		
		//0을 제거한 str의 길이를 binaryString으로 변환하여 return
		return Integer.toBinaryString(conLength);
	}
}