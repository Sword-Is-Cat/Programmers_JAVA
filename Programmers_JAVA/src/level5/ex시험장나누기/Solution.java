package level5.ex시험장나누기;

class Solution {
	public int solution(int k, int[] num, int[][] links) {

		Node root = getRootNode(num, links);

		int head = 0;
		int tail = 100000000;
		int mid = 0;

		for (int no : num)
			head = Math.max(head, no);
        
        head--;

		while (tail - head > 1) {
			mid = (head + tail) / 2;
			if (checkPossible(root, mid, k))
				tail = mid;
			else
				head = mid;
		}

		return tail;
	}

	boolean checkPossible(Node node, int size, int quantity) {
		int[] result = countTrafficQTT(node, size);
		return result[0] < quantity;
	}

	/**
	 * @return {잘라낸 트래픽 수, 잘라낸 트래픽 량}
	 */
	int[] countTrafficQTT(Node node, int size) {

		int quantity = 0;
		int decrease = 0;

		if (node.getSum() > size) {

			int leftValue = 0;
			int rightValue = 0;

			boolean leftCut = false;
			boolean rightCut = false;

			if (node.left != null) {
				int[] leftRst = countTrafficQTT(node.left, size);
				quantity += leftRst[0];
				decrease += leftRst[1];
				leftValue = node.left.getSum() - leftRst[1];
			}
			if (node.right != null) {
				int[] rightRst = countTrafficQTT(node.right, size);
				quantity += rightRst[0];
				decrease += rightRst[1];
				rightValue = node.right.getSum() - rightRst[1];
			}
			if (leftValue + node.val > size) {
				leftCut = true;
				quantity++;
				decrease += leftValue;
			}
			if (rightValue + node.val > size) {
				rightCut = true;
				quantity++;
				decrease += rightValue;
			}
			if (!leftCut && !rightCut && leftValue + rightValue + node.val > size) {
				quantity++;
				decrease += Math.max(leftValue, rightValue);
			}

		}

		int[] result = { quantity, decrease };
		return result;
	}

	Node getRootNode(int[] num, int[][] links) {

		int length = num.length;
		Node[] rooms = new Node[length];

		for (int i = 0; i < length; i++) {
			rooms[i] = new Node(i, num[i]);
		}

		for (int i = 0; i < length; i++) {

			Node room = rooms[i];
			int[] pair = links[i];

			if (pair[0] != -1)
				room.setLeft(rooms[pair[0]]);
			if (pair[1] != -1)
				room.setRight(rooms[pair[1]]);
		}

		Node root = rooms[0];
		while (root.parent != null)
			root = root.parent;

		return root;
	}
}

class Node {

	int no;
	int val;
	int sum = -1;
	Node left;
	Node right;
	Node parent;

	Node(int no, int val) {
		this.no = no;
		this.val = val;
	}

	void setLeft(Node left) {
		if (left != null) {
			this.left = left;
			left.parent = this;
		}
	}

	void setRight(Node right) {
		if (right != null) {
			this.right = right;
			right.parent = this;
		}
	}

	int getSum() {

		if (sum < 0) {
			sum = val;
			if (left != null)
				sum += left.getSum();
			if (right != null)
				sum += right.getSum();
		}
		return sum;
	}
}