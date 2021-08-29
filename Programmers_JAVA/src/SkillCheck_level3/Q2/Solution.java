package SkillCheck_level3.Q2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	public int solution(int N, int number) {

		Map<Integer, Set<Integer>> map = new HashMap<>();

		map.put(1, new HashSet<Integer>());
		map.get(1).add(N);
		if (map.get(1).contains(number))
			return 1;

		for (int i = 2; i < 9; i++) {
			map.put(i, new HashSet<Integer>());
			map.get(i).add(nnn(N, i));

			for (int j = 1; j < i; j++) {
				process(map.get(i), map.get(j), map.get(i - j));
			}

			if (map.get(i).contains(number))
				return i;
		}

		return -1;
	}

	public int nnn(int n, int i) {
		int a = (int) (Math.pow(10, i) - 1) * n / 9;
		return a;
	}

	public void process(Set<Integer> pset, Set<Integer> set1, Set<Integer> set2) {
		for (int a : set1) {
			for (int b : set2) {
				pset.add(a + b);
				pset.add(a * b);
				if (a - b > 0)
					pset.add(a - b);
				if (a / b > 0)
					pset.add(a / b);
			}
		}
	}
}