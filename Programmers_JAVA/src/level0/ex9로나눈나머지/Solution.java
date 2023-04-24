package level0.ex9로나눈나머지;

class Solution {
	public int solution(String number) {

		int sum = 0;

		for (char ch : number.toCharArray())
			sum += ch - '0';

		return sum % 9;
	}
}