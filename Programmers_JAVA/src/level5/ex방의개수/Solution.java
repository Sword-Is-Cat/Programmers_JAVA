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
			// 현재 점의 좌표를 pointSet에 추가
			areaSet.add((x+lastx)+","+(x*lastx)+","+(y+lasty)+","+(y*lasty));
			// 선이 사용하는 영역의 정보를 areaSet에 추가
			lineSet.add((x+lastx)+","+(x*lastx)+","+(y+lasty)+","+(y*lasty)+","+head);
			// 생성된 선의 정보를 lineSet에 추가

		}
		
		//중복점의수 = 전체점의수(1+arrow.length) - 중복제거점의수(pointSet.size())
		//중복선의수 = 전체선의수(arrow.length) - 중복제거선의수(lineSet.size())
		//중복점이 발생할때 방의수가 1증가하지만, 선이 중복되는 중복점의 경우 의미가 없으므로
		//방의수 = 중복점의수 - 중복선의수 = 1+lineSet.size()-pointSet.size()
		
		//같은영역내 X자로 교차하는 case를 고려하지 못해 Error 발생
		//영역은 중복되나 선이 중복하지 않는 경우(lineSet.size()-areaSet.size())를 더해주어야 정답일것으로 추정

		int answer = 1+2*lineSet.size()-pointSet.size()-areaSet.size();
		return answer;

	}
}