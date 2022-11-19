package level2.숫자카드나누기;

class Solution {
	public int solution(int[] arrayA, int[] arrayB) {

		int gcdA = arrayGcd(arrayA), gcdB = arrayGcd(arrayB);

		for (int num : arrayB) {
			if (gcdA != 0 && num % gcdA == 0) {
				gcdA = 0;
				break;
			}
		}

		for (int num : arrayA) {
			if (gcdB != 0 && num % gcdB == 0) {
				gcdB = 0;
				break;
			}
		}

		return Math.max(gcdA, gcdB);

	}

	int arrayGcd(int[] arr) {
		int rst = 0;
		for (int no : arr)
			rst = gcd(rst, no);
		return rst;
	}

	int gcd(int a, int b) {
		return a * b == 0 ? a + b : a % b == 0 ? b : gcd(b, a % b);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[] { 10, 20 }, new int[] { 5, 17 }));
	}
}