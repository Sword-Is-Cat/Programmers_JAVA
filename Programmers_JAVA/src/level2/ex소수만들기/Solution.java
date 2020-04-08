package level2.ex소수만들기;
/*
 * 문제 설명
주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 
서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.

제한사항
nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
 */

class Solution {
	static int answer = 0;

	public int solution(int[] nums) {

		boolean[] visit = new boolean[nums.length];
		int[] arr = new int[3];
		
		pickNo(arr, nums, visit, 0, 0);

		return answer;
	}

	public void pickNo(int[] arr, int[] nums, boolean[] visit, int index, int start) {
		if (index == 3) {
			if (isPrime(arr))
				answer++;
		} else {

			for (int i = start; i < nums.length-2+index; i++) {
				if (visit[i])
					continue;
				else {
					arr[index] = nums[i];
					visit[i] = true;
					pickNo(arr, nums, visit, index+1, i+1);
					visit[i] = false;
				}
			}

		}

	}

	public boolean isPrime(int[] arr) {
		int sum = arr[0] + arr[1] + arr[2];
		for (int i = 2; i * i <= sum; i++) {
			if (sum % i == 0)
				return false;
		}
		return true;
	}
}