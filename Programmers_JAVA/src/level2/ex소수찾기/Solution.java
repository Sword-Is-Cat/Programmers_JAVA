package level2.ex소수찾기;

import java.util.HashSet;

class Solution {

	static StringBuilder sb = new StringBuilder();

	public int solution(String numbers) {

		char[] arr = numbers.toCharArray();
		boolean[] visit = new boolean[arr.length];
		HashSet<Integer> set = new HashSet<>();

		addNo(set, arr, visit, arr.length);

		return set.size();
	}

	public boolean checkPrime(int no) {

		if (no == 0 || no == 1)
			return false;
		if (no == 2 || no == 3)
			return true;
		for (int i = 2; i * i <= no; i++) {
			if (no % i == 0)
				return false;
		}
		return true;
	}

	public void addNo(HashSet<Integer> set, char[] arr, boolean[] visit, int length) {

		if (sb.length() == arr.length) {
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				sb.append(arr[i]);
				int a = Integer.parseInt(sb.toString());
				if (checkPrime(a))
					set.add(a);
				addNo(set, arr, visit, length);
				sb.deleteCharAt(sb.length() - 1);
				visit[i] = false;
			}
		}
		return;
	}
}