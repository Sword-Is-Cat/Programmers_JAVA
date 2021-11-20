package level2.ex압축;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] solution(String msg) {

		List<String> dic = new ArrayList<>();
		List<Integer> ans = new ArrayList<>();

		char[] single = { 'A' };

		dic.add("");
		for (int i = 0; i < 26; i++) {
			dic.add(new String(single));
			single[0]++;
		}

		int length = msg.length();
		int index = 0;

		while (index < length) {
			int[] rst = encode(dic, msg, index);
			ans.add(rst[0]);
			index += rst[1];
		}

		int[] answer = new int[ans.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = ans.get(i);

		return answer;
	}

	public int[] encode(List<String> dic, String msg, int index) {

		int length = 0;
		int lastIndex = 0;
		int dicIndex = 0;

		while (dicIndex != -1 && index + length < msg.length()) {
			length++;
			lastIndex = dicIndex;
			dicIndex = dic.indexOf(msg.substring(index, index + length));
			//System.out.println(msg.substring(index, index + length) + " have index [" + dicIndex + "]");
		}

		if (dicIndex == -1) {
			dic.add(msg.substring(index, index + length--));
		} else {
			lastIndex = dicIndex;
		}

		int[] result = { lastIndex, length };
		//System.out.println("[" + lastIndex + "," + length + "]");
		return result;
	}

}