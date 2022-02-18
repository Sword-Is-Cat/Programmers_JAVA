package level2.ex단체사진찍기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

	char[] friends = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };

	public int solution(int n, String[] data) {

		Queue<String> photos = new LinkedList<>();
		allPhotos(photos, 0, null, null);

		for (String rule : data) {
			photos = applyRule(photos, rule);
		}

		return photos.size();
	}

	void allPhotos(Queue<String> photos, int index, char[] line, boolean[] visit) {

		if (index == 0) {
			line = new char[8];
			visit = new boolean[8];
		} else if (index == 8) {
			photos.add(new String(line));
		}

		for (int fNo = 0; fNo < 8; fNo++) {
			if (!visit[fNo]) {
				line[index] = friends[fNo];
				visit[fNo] = true;
				allPhotos(photos, index + 1, line, visit);
				visit[fNo] = false;
			}
		}
	}

	Queue<String> applyRule(Queue<String> photos, String rule) {

		Queue<String> result = new LinkedList<>();
		char[] detail = rule.toCharArray();

		while (!photos.isEmpty()) {
			String photo = photos.poll();

			int index1 = photo.indexOf(detail[0]);
			int index2 = photo.indexOf(detail[2]);
			int dif = Math.abs(index1 - index2) - 1;
			int goal = Integer.parseInt(String.valueOf(detail[4]));

			if ((detail[3] == '=' && dif == goal) || (detail[3] == '>' && dif > goal)
					|| (detail[3] == '<' && dif < goal)) {
				result.add(photo);
			}

		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().solution(2, new String[] { "N~F=0", "R~T>2" }));
	}
}