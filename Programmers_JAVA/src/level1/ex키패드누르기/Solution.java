package level1.ex키패드누르기;

class Solution {
	public String solution(int[] numbers, String hand) {

		boolean isRight = hand.equals("right");
		StringBuilder sb = new StringBuilder();

		int left = 10;
		int right = 12;

		for (int i : numbers) {

			if (i == 0)
				i = 11;

			switch (i % 3) {
			case 1:
				sb.append("L");
				left = i;
				break;
			case 0:
				sb.append("R");
				right = i;
				break;
			default:
				if (distance(left, i) > distance(right, i)) {
					sb.append("R");
					right = i;
				} else if (distance(left, i) < distance(right, i)) {
					sb.append("L");
					left = i;
				} else if (isRight) {
					sb.append("R");
					right = i;
				} else {
					sb.append("L");
					left = i;
				}
				break;

			}
		}

		return sb.toString();
	}

	public int distance(int a, int b) {

		int garo = Math.abs((a - 1) % 3 - (b - 1) % 3);
		int sero = Math.abs((a - 1) / 3 - (b - 1) / 3);

		return garo + sero;
	}
}