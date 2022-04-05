package level2.ex타겟넘버;

class Solution {
	public int solution(int[] numbers, int target) {
		return dfs(numbers, target, 0, 0);
	}

	int dfs(int[] numbers, int target, int index, int sum) {

		int result = 0;

		if (index == numbers.length) {
			result = target == sum ? 1 : 0;
		} else {
			result += dfs(numbers, target, index + 1, sum + numbers[index]);
			result += dfs(numbers, target, index + 1, sum - numbers[index]);
		}
		return result;
	}
}

class Solution_ {

	int[] numbers;
	int target2;
	int answer;

	public int solution(int[] numbers, int target) {

		this.numbers = numbers;

		for (int no : numbers)
			target2 += no;

		/*
		 * 합이 (sum-target)/2 이 되는 numbers의 개체들의 조합이 있다면 그 수 들을 + > - 로 변경하는 것으로 조건이 만족된다
		 */
		target2 = (target2 - target) / 2;

		process(0, 0);

		return answer;
	}

	public void process(int index, int sum) {

		if (sum > target2) // 합이 target2보다 커졌다 > 버린다
			return;
		else if (sum == target2) { // 합==target2 이다 > 조건만족하므로 answer 증가 후 종료
			answer++;
			return;
		} else { // 합이 target2에 도달하지 못했다 > 더돌린다
			for (int i = index; i < numbers.length; i++)
				process(i + 1, sum + numbers[i]);
		}
		// index 중복을 피하기위해 현재의 index+1부터 시작하도록 한다
	}
}