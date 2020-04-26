package level2.ex소수만들기;

/*
 * ���� ����
�־��� ���� �� 3���� ���� ������ �� �Ҽ��� �Ǵ� ����� ������ ���Ϸ��� �մϴ�. 
���ڵ��� ����ִ� �迭 nums�� �Ű������� �־��� ��, nums�� �ִ� ���ڵ� �� 
���� �ٸ� 3���� ��� ������ �� �Ҽ��� �Ǵ� ����� ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.

���ѻ���
nums�� ����ִ� ������ ������ 3�� �̻� 50�� �����Դϴ�.
nums�� �� ���Ҵ� 1 �̻� 1,000 ������ �ڿ����̸�, �ߺ��� ���ڰ� ������� �ʽ��ϴ�.
 */

class Solution {
	static int answer = 0;
	public int solution(int[] nums) {
		int[] arr = new int[3];
		pickNo(arr, nums, 0, 0);
		return answer;
	}
	public void pickNo(int[] arr, int[] nums, int index, int start) {
		if (index == 3) {
			if (isPrime(arr))
				answer++;
		} else {
			for (int i = start; i < nums.length - 2 + index; i++) {
				arr[index] = nums[i];
				pickNo(arr, nums, index + 1, i + 1);
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