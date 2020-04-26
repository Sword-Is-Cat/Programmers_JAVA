package level2.exJadenCase문자열만들기;


/*
���� ����
JadenCase�� ��� �ܾ��� ù ���ڰ� �빮���̰�, �� ���� ���ĺ��� �ҹ����� ���ڿ��Դϴ�. 
���ڿ� s�� �־����� ��, s�� JadenCase�� �ٲ� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ����ּ���.
���� ����
s�� ���� 1 �̻��� ���ڿ��Դϴ�.
s�� ���ĺ��� ���鹮��(" ")�� �̷���� �ֽ��ϴ�.
ù ���ڰ� ������ �ƴҶ����� �̾����� ������ �ҹ��ڷ� ���ϴ�. ( ù��° ����� �� ���� )
*/

class Solution {
  public String solution(String s) {
      StringBuilder sb = new StringBuilder();
      String[] arr = s.split(" ");
      for(int i = 0 ; i<arr.length ; i++){
          arr[i] = jaden(arr[i]);
          sb.append(arr[i]);
          sb.append(' ');
      }
      if(sb.length() != s.length())
        sb.delete(sb.length()-1,sb.length());
      return sb.toString();
  }
    public String jaden(String str){
        if(str.length()==0)
            return str;
        str = str.toLowerCase();
        char[] arr = str.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        return new String(arr);
    }
}