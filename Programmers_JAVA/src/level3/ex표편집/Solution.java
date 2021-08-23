package level3.ex표편집;

import java.util.Stack;

class Solution {

	int node = 0;
	int length = 0;
	boolean[] delYN;
	Stack<Integer> recycleBin;

	public String solution(int n, int k, String[] cmd) {

		node = k;
		length = n;
		delYN = new boolean[n];
		recycleBin = new Stack<>();

		for (String row : cmd) {
			
			//System.out.println("############");
			//System.out.println(row);

			if (row.equals("C"))
				clear();
			else if (row.equals("Z"))
				undo();
			else {

				String[] temp = row.split(" ");

				if (temp[0].equals("U"))
					move(-1, Integer.parseInt(temp[1]));
				else if (temp[0].equals("D"))
					move(1, Integer.parseInt(temp[1]));

			}
			
			//System.out.println("node:"+node);

		}

		StringBuilder answer = new StringBuilder();

		for (boolean isDel : delYN) {
			if (isDel)
				answer.append('X');
			else
				answer.append('O');

		}

		return answer.toString();
	}

	public void move(int direction, int distance) {

		if (distance == 0)
			return;
		
		if (node + direction == length) {
			move(-1,1);
			return;
		}



		if (delYN[node + direction]) {
			node += direction;
		} else {
			node += direction;
			distance--;
		}

		move(direction, distance);

	}

	public void clear() {
		delYN[node] = true;
		recycleBin.push(node);
		move(1, 1);
	}

	public void undo() {
		delYN[recycleBin.pop()] = false;
	}
	
	public static void main(String[] args) {
		String[] arr = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
		System.out.println(new Solution().solution(8, 2, arr));
	}
	
	
}