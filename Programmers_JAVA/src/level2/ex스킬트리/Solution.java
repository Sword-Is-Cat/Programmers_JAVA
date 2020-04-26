package level2.ex스킬트리;


/*
���� ����
���� ��ų�̶� � ��ų�� ���� ���� ���� ����� �ϴ� ��ų�� ���մϴ�.

���� ��� ���� ��ų ������ ����ũ �� ����Ʈ�� ��Ʈ �� ����϶�, ����� ������ ���� ����Ʈ�� ��Ʈ�� ����� �ϰ�, 
����Ʈ�� ��Ʈ�� ������ ���� ����ũ�� ����� �մϴ�.

�� ������ ���� �ٸ� ��ų(���� ��)�� ������ ������� ��� �� �ֽ��ϴ�. ���� ����ũ �� ���� �� ����Ʈ�� ��Ʈ �� ����� ���� ��ųƮ���� 
����������, ��� �� ����ũ�� ����Ʈ�� ��Ʈ �� ����ũ �� ���� �� ����� ���� ��ųƮ���� �Ұ����մϴ�.

���� ��ų ���� skill�� �������� ���� ��ųƮ��1�� ���� �迭 skill_trees�� �Ű������� �־��� ��, ������ ��ųƮ�� ������ return �ϴ� 
solution �Լ��� �ۼ����ּ���.

���� ����
��ų�� ���ĺ� �빮�ڷ� ǥ���ϸ�, ��� ���ڿ��� ���ĺ� �빮�ڷθ� �̷���� �ֽ��ϴ�.
��ų ������ ��ųƮ���� ���ڿ��� ǥ���մϴ�.
���� ���, C �� B �� D ��� CBD�� ǥ���մϴ�
���� ��ų ���� skill�� ���̴� 1 �̻� 26 �����̸�, ��ų�� �ߺ��� �־����� �ʽ��ϴ�.
skill_trees�� ���� 1 �̻� 20 ������ �迭�Դϴ�.
skill_trees�� ���Ҵ� ��ų�� ��Ÿ���� ���ڿ��Դϴ�.
skill_trees�� ���Ҵ� ���̰� 2 �̻� 26 ������ ���ڿ��̸�, ��ų�� �ߺ��� �־����� �ʽ��ϴ�.
*/
class Solution {
	public int solution(String skill, String[] skill_trees) {

		int answer = 0;
		char[] skillArr = skill.toCharArray();
		if (skillArr.length == 1) {
			return skill_trees.length;
		}
		for (String st : skill_trees) {
			char[] stArr = st.toCharArray();
			int[] transArr = new int[skillArr.length];
			for (int i = 0; i < stArr.length; i++) {
				for (int j = 0; j < skillArr.length; j++) {
					if (stArr[i] == skillArr[j]) {
						transArr[j] = stArr.length - i;
					}
				}
			}
			for (int i = 0; i < transArr.length - 1; i++) {
				if (transArr[i] < transArr[i + 1]) {
					break;
				}
				if (i == transArr.length - 2) {
					answer++;
				}
			}
		}
		return answer;
	}
}