package level3.ex표편집;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

class Solution {

	public String solution(int n, int k, String[] cmd) {

		Stack<Integer> recycleBin = new Stack<>();
		LinkedList<Integer> list = new LinkedList<>();
		int index = k;

		for (int i = 0; i < n; i++) {
			list.add(i);
		}

		for (String row : cmd) {

			if (row.equals("C")) {
				recycleBin.add(list.remove(index));
				if(index == list.size())
					index--;
			}else if (row.equals("Z")) {
				int temp = list.get(index);
				list.add(recycleBin.pop());
				Collections.sort(list);
				if(temp != list.get(index))
					index++;
			} else {

				String[] temp = row.split(" ");

				if (temp[0].equals("U"))
					index -= Integer.parseInt(temp[1]);
				else if (temp[0].equals("D"))
					index += Integer.parseInt(temp[1]);

			}

		}

		char[] arr = new char[n];
		
		for(int i = 0 ; i<list.size() ; i++) {
			arr[list.get(i)] = 'O';
		}
		
		return new String(arr).replace((char)0, 'X');
	}

	public static void main(String[] args) {
		String[] arr = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C" };
		System.out.println(new Solution().solution(8, 2, arr));
	}

}