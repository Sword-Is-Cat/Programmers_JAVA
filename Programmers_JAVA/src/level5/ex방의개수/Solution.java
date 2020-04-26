package level5.ex방의개수;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/49190
 */

import java.util.HashSet;

class Solution {
	public int solution(int[] arrows) {

		HashSet<String> pointSet = new HashSet<>();
		HashSet<String> areaSet = new HashSet<>();
		HashSet<String> lineSet = new HashSet<>();

		int x = 0;
		int y = 0;
		int lastx = 0;
		int lasty = 0;
		int head = 0;
		pointSet.add(x + "," + y);
		
		int[][] arr = {{0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1, -1}, {-1,0}, {-1,1}};

		for (int arrow : arrows) {
			head = arrow%4;
			lastx = x;
			lasty = y;
			x += arr[arrow][0];
			y += arr[arrow][1];
			
			pointSet.add(x + "," + y);
			// ���� ���� ��ǥ�� pointSet�� �߰�
			areaSet.add((x+lastx)+","+(x*lastx)+","+(y+lasty)+","+(y*lasty));
			// ���� ����ϴ� ������ ������ areaSet�� �߰�
			lineSet.add((x+lastx)+","+(x*lastx)+","+(y+lasty)+","+(y*lasty)+","+head);
			// ������ ���� ������ lineSet�� �߰�

		}
		
		//�ߺ����Ǽ� = ��ü���Ǽ�(1+arrow.length) - �ߺ��������Ǽ�(pointSet.size())
		//�ߺ����Ǽ� = ��ü���Ǽ�(arrow.length) - �ߺ����ż��Ǽ�(lineSet.size())
		//�ߺ����� �߻��Ҷ� ���Ǽ��� 1����������, ���� �ߺ��Ǵ� �ߺ����� ��� �ǹ̰� �����Ƿ�
		//���Ǽ� = �ߺ����Ǽ� - �ߺ����Ǽ� = 1+lineSet.size()-pointSet.size()
		
		//���������� X�ڷ� �����ϴ� case�� ������� ���� Error �߻�
		//������ �ߺ��ǳ� ���� �ߺ����� �ʴ� ���(lineSet.size()-areaSet.size())�� �����־�� �����ϰ����� ����

		int answer = 1+2*lineSet.size()-pointSet.size()-areaSet.size();
		return answer;

	}
}