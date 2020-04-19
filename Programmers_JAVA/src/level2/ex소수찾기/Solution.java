package level2.ex소수찾기;

import java.util.HashSet;

class Solution {

	StringBuilder sb = new StringBuilder();
	HashSet<Integer> set = new HashSet<>();
	char[] arr;
	boolean[] visit;
	
	public int solution(String numbers) {

		arr = numbers.toCharArray();
		visit = new boolean[arr.length];

		addNo();

		return set.size();
	}

	public boolean checkPrime(int no) {

		if (no == 0 | no == 1)
			return false;
		if (no == 2 | no == 3)
			return true;
		for (int i = 2; i * i <= no; i++) {
			if (no % i == 0)
				return false;
		}
		return true;
	}

	public void addNo() {

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
				addNo();
				sb.deleteCharAt(sb.length() - 1);
				visit[i] = false;
			}
		}
		return;
	}
}