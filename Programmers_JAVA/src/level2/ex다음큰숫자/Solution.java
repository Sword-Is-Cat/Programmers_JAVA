package level2.ex다음큰숫자;


/*
���� ����
�ڿ��� n�� �־����� ��, n�� ���� ū ���ڴ� ������ ���� ���� �մϴ�.
���� 1. n�� ���� ū ���ڴ� n���� ū �ڿ��� �Դϴ�.
���� 2. n�� ���� ū ���ڿ� n�� 2������ ��ȯ���� �� 1�� ������ �����ϴ�.
���� 3. n�� ���� ū ���ڴ� ���� 1, 2�� �����ϴ� �� �� ���� ���� �� �Դϴ�.
���� �� 78(1001110)�� ���� ū ���ڴ� 83(1010011)�Դϴ�.
�ڿ��� n�� �Ű������� �־��� ��, n�� ���� ū ���ڸ� return �ϴ� solution �Լ��� �ϼ����ּ���.
���� ����
n�� 1,000,000 ������ �ڿ��� �Դϴ�.
*/

class Solution {
  public int solution(int n) {
      int i = binarySum(n);
      while(true){
          if(i == binarySum(++n))
              return n;
      }
  }
    public int binarySum(int n){
        int sum = 0;
        char[] arr = Integer.toBinaryString(n).toCharArray();
        for(char ch : arr){
            if(ch == '1')
                sum++;
        }
        return sum;
    }
}