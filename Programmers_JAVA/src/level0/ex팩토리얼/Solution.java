package level0.ex팩토리얼;

class Solution {
	public int solution(int n) {

		int num = 1, app = 1;

		while (num * app <= n) {
			app *= num++;
		}

		return num - 1;
	}
}