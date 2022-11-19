package level1.옹알이2;

class Solution {

	String[] dic = { "aya", "ye", "woo", "ma" };

	public int solution(String[] babbling) {

		int answer = 0;

		for (String babble : babbling) {
			if (ableToSay(babble))
				answer++;
		}

		return answer;
	}

	boolean ableToSay(String sentence) {

		boolean working = true;
		String prev = "";

//		System.out.println("check able to say : " + sentence);

		while (working && sentence.length() > 0) {

			switch (sentence.charAt(0)) {
			case 'a':
				if (sentence.indexOf(dic[0]) == 0 && !dic[0].equals(prev)) {
					sentence = sentence.replaceFirst(dic[0], "");
					prev = dic[0];
				} else
					return false;
				break;
			case 'y':
				if (sentence.indexOf(dic[1]) == 0 && !dic[1].equals(prev)) {
					sentence = sentence.replaceFirst(dic[1], "");
					prev = dic[1];
				} else
					return false;
				break;
			case 'w':
				if (sentence.indexOf(dic[2]) == 0 && !dic[2].equals(prev)) {
					sentence = sentence.replaceFirst(dic[2], "");
					prev = dic[2];
				} else
					return false;
				break;
			case 'm':
				if (sentence.indexOf(dic[3]) == 0 && !dic[3].equals(prev)) {
					sentence = sentence.replaceFirst(dic[3], "");
					prev = dic[3];
				} else
					return false;
				break;
			default:
				working = false;
				break;
			}

		}

//		System.out.println("done!! [" + sentence + "]");

		return sentence.length() == 0;
	}

	/*
	 * public static void main(String[] args) { new Solution().solution(new String[]
	 * { "aya", "yee", "u", "maa" }); }
	 */

}