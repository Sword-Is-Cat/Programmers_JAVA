package level3.ex연속펄스부분수열의합;

class Solution {
	public long solution(int[] sequence) {

		long sum = 0;
		long oddMinSum = 0, oddMaxGap = -sequence[0];
		long evenMinSum = 0, evenMaxGap = sequence[0];

		for (int i = 0; i < sequence.length; i++) {

			sum += i % 2 == 0 ? sequence[i] : -sequence[i];

			oddMaxGap = Math.max(oddMaxGap, -sum - oddMinSum);
			evenMaxGap = Math.max(evenMaxGap, sum - evenMinSum);

			oddMinSum = Math.min(oddMinSum, -sum);
			evenMinSum = Math.min(evenMinSum, sum);
		}
		
		return Math.max(oddMaxGap, evenMaxGap);
	}
}