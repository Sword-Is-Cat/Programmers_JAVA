package level1.ex개인정보수집유효기간;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
	public int[] solution(String today, String[] terms, String[] privacies) {

		CustomDate _today = new CustomDate(today);
		HashMap<String, Integer> termsMap = new HashMap<>();

		for (String term : terms) {
			String[] arr = term.split(" ");
			termsMap.put(arr[0], Integer.parseInt(arr[1]));
		}

		ArrayList<Integer> ans = new ArrayList<>();

		for (int idx = 0; idx < privacies.length; idx++) {

			String[] arr = privacies[idx].split(" ");

			CustomDate expireDate = new CustomDate(arr[0]).addMonth(termsMap.get(arr[1]));

			if (_today.compareTo(expireDate) >= 0)
				ans.add(idx);

		}

		return ans.stream().mapToInt(i -> (i + 1)).toArray();
	}
}

class CustomDate implements Comparable<CustomDate> {

	int year;
	int month;
	int day;

	CustomDate(String dateStr) {
		String[] arr = dateStr.split("[^0-9]");
		year = Integer.parseInt(arr[0]);
		month = Integer.parseInt(arr[1]);
		day = Integer.parseInt(arr[2]);
	}

	CustomDate addMonth(int m) {
		month += m;
		if (month > 12) {
			year += (month - 1) / 12;
			month = (month - 1) % 12 + 1;
		}
		return this;
	}

	@Override
	public int compareTo(CustomDate target) {
		if (year != target.year)
			return year - target.year;
		if (month != target.month)
			return month - target.month;
		return day - target.day;
	}
}