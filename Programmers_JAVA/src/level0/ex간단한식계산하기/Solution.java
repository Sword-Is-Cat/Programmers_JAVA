package level0.ex간단한식계산하기;

class Solution {
	public int solution(String binomial) {
		String[] arr = binomial.split("[^0-9]+");
		int a = Integer.parseInt(arr[0]), b = Integer.parseInt(arr[1]);

		String op = binomial.replaceAll("[0-9 ]+", "");

		switch (op) {
		case "+":
			a += b;
			break;
		case "-":
			a -= b;
			break;
		case "*":
			a *= b;
			break;
		case "/":
			a /= b;
			break;
		}

		return a;
	}
}