package level1.ex성격유형검사하기;

class Solution {
	public String solution(String[] survey, int[] choices) {

		int[] points = new int[4];

		for (int i = 0; i < survey.length; i++) {

			String type = survey[i];
			int point = choices[i] - 4;

			switch (type) {
			case "RT":
				point *= -1;
			case "TR":
				points[0] += point;
				break;
			case "CF":
				point *= -1;
			case "FC":
				points[1] += point;
				break;
			case "JM":
				point *= -1;
			case "MJ":
				points[2] += point;
				break;
			case "AN":
				point *= -1;
			case "NA":
				points[3] += point;
				break;

			}

		}

		char[] arr = new char[4];

		arr[0] = points[0] < 0 ? 'T' : 'R';
		arr[1] = points[1] < 0 ? 'F' : 'C';
		arr[2] = points[2] < 0 ? 'M' : 'J';
		arr[3] = points[3] < 0 ? 'N' : 'A';

		return new String(arr);
	}
}