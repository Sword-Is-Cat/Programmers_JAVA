package level1.ex같은숫자는싫어;

/*
���� ����
�迭 arr�� �־����ϴ�. �迭 arr�� �� ���Ҵ� ���� 0���� 9������ �̷���� �ֽ��ϴ�. 
�̶�, �迭 arr���� ���������� ��Ÿ���� ���ڴ� �ϳ��� ����� ���� �����Ϸ��� �մϴ�. 
��, ���ŵ� �� ���� ������ ��ȯ�� ���� �迭 arr�� ���ҵ��� ������ �����ؾ� �մϴ�. ���� ���,

arr = [1, 1, 3, 3, 0, 1, 1] �̸� [1, 3, 0, 1] �� return �մϴ�.
arr = [4, 4, 4, 3, 3] �̸� [4, 3] �� return �մϴ�.
�迭 arr���� ���������� ��Ÿ���� ���ڴ� �����ϰ� ���� ������ return �ϴ� solution �Լ��� �ϼ��� �ּ���.

���ѻ���
�迭 arr�� ũ�� : 1,000,000 ������ �ڿ���
�迭 arr�� ������ ũ�� : 0���� ũ�ų� ���� 9���� �۰ų� ���� ����
*/
import java.util.*;

public class Solution {
		public int[] solution(int []arr) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(arr[0]);
        
        for(int i = 1; i<arr.length ; i++) {
        	
        	if(arr[i-1] != arr[i])
        		list.add(arr[i]);
        }
        
        answer = new int[list.size()];
        
        for(int i = 0 ; i<list.size() ; i++) {
        	
        	answer[i] = list.get(i);
        }
        
        return answer;
	}
}