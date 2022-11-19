package level2.ex할인행사;

import java.util.HashMap;

class Solution {
	public int solution(String[] want, int[] number, String[] discount) {

		int[] dcCnt = new int[want.length];
		HashMap<String, Integer> idxMap = new HashMap<>();

		for (int i = 0; i < want.length; i++)
			idxMap.put(want[i], i);

		int days = 0;
		for (int num : number)
			days += num;

		days--;
		
		for (int i = 0; i < days; i++) {
			//System.out.println(discount[i]);
			if (idxMap.containsKey(discount[i]))
				dcCnt[idxMap.get(discount[i])]++;
		}

		int answer = 0;

		for (int date = 0; date + days < discount.length; date++) {

			//System.out.println("when date:"+date);
			String prod = discount[date + days];
			if (idxMap.containsKey(prod))
				dcCnt[idxMap.get(prod)]++;
			if (date > 0) {
				String rmvProd = discount[date - 1];
				if (idxMap.containsKey(rmvProd))
					dcCnt[idxMap.get(rmvProd)]--;
			}

			if (isSame(number, dcCnt))
				answer++;

		}

		return answer;
	}

	boolean isSame(int[] number, int[] dcCnt) {
		//System.out.println("CALL");
		for (int i = 0; i < number.length; i++) {
			
			//System.out.println("index:"+i+", numVal:"+number[i] +", cnt:"+ dcCnt[i]);
			if (number[i] != dcCnt[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		new Solution().solution(new String[] { "banana", "apple", "rice", "pork", "pot" }, new int[] { 3, 2, 2, 2, 1 },
				new String[] { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
						"pot", "banana", "apple", "banana" });
	}
}