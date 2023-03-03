package level3.ex연속펄스부분수열의합;

class Solution {
	public long solution(int[] sequence) {

		long sum = 0;
		long maxSum = 0, minGap = sequence[0];
		long minSum = 0, maxGap = sequence[0];

		for (int i = 0; i < sequence.length; i++) {

			sum += i % 2 == 0 ? sequence[i] : -sequence[i];

			minGap = Math.min(minGap, sum - maxSum);
			maxGap = Math.max(maxGap, sum - minSum);

			maxSum = Math.max(maxSum, sum);
			minSum = Math.min(minSum, sum);
		}

		return Math.max(-minGap, maxGap);
	}
}