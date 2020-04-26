package level2.exN개의최소공배수;


/*
���� ����
�� ���� �ּҰ����(Least Common Multiple)�� �Էµ� �� ���� ��� �� ������ �Ǵ� ���� ���� ���ڸ� �ǹ��մϴ�. 
���� ��� 2�� 7�� �ּҰ������ 14�� �˴ϴ�. ���Ǹ� Ȯ���ؼ�, n���� ���� �ּҰ������ n ���� ������ ��� �� 
������ �Ǵ� ���� ���� ���ڰ� �˴ϴ�. n���� ���ڸ� ���� �迭 arr�� �ԷµǾ��� �� �� ������ �ּҰ������ ��ȯ�ϴ� �Լ�, 
solution�� �ϼ��� �ּ���.
���� ����
arr�� ���� 1�̻�, 15������ �迭�Դϴ�.
arr�� ���Ҵ� 100 ������ �ڿ����Դϴ�.
*/

class Solution {
  public int solution(int[] arr) {
      int answer = arr[0];
      for(int i = 1 ; i<arr.length ; i++){
          answer = lcm(answer, arr[i]);
      }
      return answer;
  }
  public int lcm(int a, int b){
      return a*b/gcd(a,b);
  }
  public int gcd(int a, int b){
      return (a%b == 0) ? b : gcd(b, a%b) ;
  }
}