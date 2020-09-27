package level2.ex문자열압축;

class Solution {
	public int solution(String s) {
		
		if(s.length()==1)
			return 1;
		
		int answer = Integer.MAX_VALUE;
		
		for(int i = 1 ; i<=s.length()/2 ; i++)
			answer = Integer.min(answer, zip(s,i));
		
		return answer;
	}

	int zip(String str, int n) {

		int length = str.length();
		int tail = length % n == 0 ? 0 : 1;
		String[] arr = new String[length / n + tail];

		for (int i = 0; i < arr.length - 1; i++)
			arr[i] = str.substring(i * n, (i + 1) * n);

		arr[arr.length - 1] = str.substring((arr.length - 1) * n);

		StringBuilder sb = new StringBuilder();
		String temp = null;
		int count = 1;

		for (String s : arr) {
			if (temp == null)
				temp = s;
			else if (temp.equals(s))
				count++;
			else {
				if (count != 1)
					sb.append(count);
				sb.append(temp);
				temp = s;
				count = 1;
			}
		}
		if (count != 1)
			sb.append(count);
		sb.append(temp);
		
		return sb.length();
	}
}