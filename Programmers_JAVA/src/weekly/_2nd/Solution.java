package weekly._2nd;

class Solution {

	int[][] scores;

	public String solution(int[][] scores) {

		StringBuilder sb = new StringBuilder();
		this.scores = scores;
		
		for(int i = 0 ; i<scores.length ; i++) {
			sb.append(calcGrade(getAvg(i)));
		}

		return sb.toString();
	}

	public double getAvg(int index) {

		boolean isMax = true;
		boolean isMin = true;

		int myScore = scores[index][index];
		double sum = 0D;
		int length = scores.length;

		double avg = 0D;

		for (int i = 0; i < scores.length; i++) {

			int score = scores[i][index];
			sum += score;

			if (i != index) {
				if (myScore >= score)
					isMin = false;
				if (myScore <= score)
					isMax = false;

			}

		}
		
		if(isMin|| isMax) {
			sum -= myScore;
			length--;
		}

		return sum / length;
	}

	public char calcGrade(double score) {

		char grade = ' ';

		if (score < 50)
			grade = 'F';
		else if (score < 70)
			grade = 'D';
		else if (score < 80)
			grade = 'C';
		else if (score < 90)
			grade = 'B';
		else
			grade = 'A';

		return grade;

	}
/*
	public static void main(String[] args) {
		int[][] s = { { 100, 90, 98, 88, 65 }, { 50, 45, 99, 85, 77 }, { 47, 88, 95, 80, 67 }, { 61, 57, 100, 80, 65 },
				{ 24, 90, 94, 75, 65 } };
		System.out.println(new Solution().solution(s));
	}
	*/
}