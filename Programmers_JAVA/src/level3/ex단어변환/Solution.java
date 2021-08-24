package level3.ex단어변환;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

	boolean[][] isPossible;
	Map<Integer, Set<Integer>> dpMap;
	Set<Integer> allSet;

	public int solution(String begin, String target, String[] words) {

		isPossible = new boolean[words.length][words.length];
		dpMap = new HashMap<>();
		allSet = new HashSet<>();

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if (i == j) {
					isPossible[i][j] = false;
				} else if (i > j) {
					isPossible[i][j] = isPossible[j][i];
				} else {
					isPossible[i][j] = isConnect(words[i], words[j]);
				}
				
				//System.out.println("i:"+i+", j:"+j+", rst:"+isPossible[i][j]);
			}
		}

		int targetIndex = -1;

		for (int i = 0; i < words.length; i++) {

			if(target.equals(words[i])) {
				targetIndex = i;
			}
		}
		
		//System.out.println("target:"+targetIndex);
		
		int key = 1;
		dpMap.put(key, new HashSet<Integer>());
		for(int i = 0 ; i<words.length ; i++) {
			if(isConnect(begin, words[i])) {
				allSet.add(i);
				dpMap.get(key).add(i);
			}
		}

		if(dpMap.get(key).contains(targetIndex)) {
			return 1;
		}

		while (key < words.length) {

			Set<Integer> prevSet = dpMap.get(key++);
			Set<Integer> nextSet = new HashSet<>();
			
			//System.out.println("key:"+key);
			

			for (int prevIndex : prevSet) {
				//System.out.println(prevIndex+":"+words[prevIndex]);

				for (int i = 0; i < words.length; i++) {
					
					if(isPossible[prevIndex][i] && allSet.add(i)) {
						nextSet.add(i);
					}

				}

			}
			
			if(nextSet.contains(targetIndex))
				return key;
			else
				dpMap.put(key, nextSet);
		}

		return 0;
	}

	public boolean isConnect(String str1, String str2) {
		// 두 문자열이 한글자만 다른 경우 true, 그 외 경우 false;
		boolean rst = true;

		if (str1.length() != str2.length() || str1.equals(str2)) {
			rst = false;
		} else {

			boolean chance = true;
			char[] chArr1 = str1.toCharArray();
			char[] chArr2 = str2.toCharArray();

			for (int i = 0; i < chArr1.length; i++) {

				if (chArr1[i] != chArr2[i]) {

					if (chance) {
						chance = false;
					} else {
						rst = false;
						break;
					}
				}
			}
		}

		return rst;

	}
	
	public static void main(String[] args) {
		String[] arr = {"hot", "dot", "dog", "lot", "log"};
		System.out.println(new Solution().solution("hot", "lot", arr));
	}

}