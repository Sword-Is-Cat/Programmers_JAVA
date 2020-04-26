package level1.ex두정수사이의합;

/*
���� ����
�� ���� a, b�� �־����� �� a�� b ���̿� ���� ��� ������ ���� �����ϴ� �Լ�, solution�� �ϼ��ϼ���.
���� ��� a = 3, b = 5�� ���, 3 + 4 + 5 = 12�̹Ƿ� 12�� �����մϴ�.

���� ����
a�� b�� ���� ���� �� �� �ƹ� ���� �����ϼ���.
a�� b�� -10,000,000 �̻� 10,000,000 ������ �����Դϴ�.
a�� b�� ��Ұ���� ���������� �ʽ��ϴ�.
*/

//Math.abs�� �̿��� �ڵ� 
class Solution {

    public long solution(int a, int b) {

        return (a+b)*((long)Math.abs(a-b)+1)/2;
            
    }
    
}

/*
class Solution {

    public long solution(int a, int b) {

        long answer = 0;
       
        long sum = a+b;
        
        long count = 0;
        if(a>b){
            count = a-b+1;
        }else{
            count = b-a+1;
        }
        
        answer = sum*count/2;
        
        return answer;
            
    }
    
}
*/