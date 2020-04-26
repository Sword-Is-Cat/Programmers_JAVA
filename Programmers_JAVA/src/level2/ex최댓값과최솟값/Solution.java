package level2.ex최댓값과최솟값;


/*
���� ����
���ڿ� s���� �������� ���е� ���ڵ��� ����Ǿ� �ֽ��ϴ�. str�� ��Ÿ���� ���� �� �ּҰ��� �ִ밪�� ã�� �̸� 
(�ּҰ�) (�ִ밪)������ ���ڿ��� ��ȯ�ϴ� �Լ�, solution�� �ϼ��ϼ���.
������� s�� 1 2 3 4��� 1 4�� �����ϰ�, -1 -2 -3 -4��� -4 -1�� �����ϸ� �˴ϴ�.
���� ����
s���� �� �̻��� ������ �������� ���еǾ� �ֽ��ϴ�.
*/

import java.util.TreeSet;

class Solution {
  public String solution(String s) {

      String[] arr = s.split(" ");
      TreeSet<Integer> set = new TreeSet<>();
    
      for(String str : arr){         
           set.add(Integer.parseInt(str));
      }
    
      int max = set.last();
      int min = set.first();

      return min + " " + max;
  }
}