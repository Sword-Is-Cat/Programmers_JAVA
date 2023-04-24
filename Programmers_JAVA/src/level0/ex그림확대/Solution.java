package level0.ex그림확대;

class Solution {
	public String[] solution(String[] picture, int k) {
		String[] answer = new String[picture.length * k];
		int idx = 0;

		for (String pic : picture) {
			String enlarge = enlargeString(pic, k);
			for (int i = 0; i < k; i++)
				answer[idx++] = enlarge;
		}
		return answer;
	}

	private String enlargeString(String str, int k) {
		StringBuilder sb = new StringBuilder();
		for (char ch : str.toCharArray()) {
			for (int i = 0; i < k; i++)
				sb.append(ch);
		}
		return sb.toString();
	}
}