package level4.ex4동굴탐험;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Solution {

	public boolean solution(int n, int[][] path, int[][] order) {

		Room[] rooms = getRoomArray(n);
		Room root = rooms[0];

		buildPath(rooms, path);
		buildOrder(rooms, order);

		process(root);

		boolean answer = true;

		for (int[] ord : order) {
			answer &= rooms[ord[1]].visit;
		}

		return answer;
	}

	public Room[] getRoomArray(int n) {

		Room[] rooms = new Room[n];
		for (int i = 0; i < n; i++)
			rooms[i] = new Room(i);

		return rooms;
	}

	public void buildPath(Room[] rooms, int[][] path) {

		Queue<int[]> pathWork = new LinkedList<>(Arrays.asList(path));
		Set<Room> parents = new HashSet<>();
		parents.add(rooms[0]);

		while (!pathWork.isEmpty()) {
			int[] current = pathWork.poll();

			if (parents.contains(rooms[current[0]]) || parents.contains(rooms[current[1]])) {

				Room pt;
				Room ch;
				if (parents.contains(rooms[current[0]])) {
					pt = rooms[current[0]];
					ch = rooms[current[1]];
				} else {
					pt = rooms[current[1]];
					ch = rooms[current[0]];
				}
				ch.setParent(true, pt);
				parents.add(ch);

			} else {
				pathWork.add(current);
			}

		}

	}

	public void buildOrder(Room[] rooms, int[][] order) {
		for (int[] ord : order) {
			rooms[ord[1]].setParent(false, rooms[ord[0]]);
		}

	}

	public void process(Room root) {

		Stack<Room> stack = new Stack<>();
		stack.add(root);

		while (!stack.isEmpty()) {

			Set<Room> result = stack.pop().check();
			if (result != null)
				stack.addAll(result);

		}

	}

	public static void main(String[] args) {
		int[][] path = { { 0, 1 }, { 0, 3 }, { 0, 7 }, { 8, 1 }, { 3, 6 }, { 1, 2 }, { 4, 7 }, { 7, 5 } };
		int[][] order = { { 8, 5 }, { 6, 7 }, { 4, 1 } };
		new Solution().solution(9, path, order);
	}

}

class Room {

	int roomNo;
	boolean visit;
	Room pathPT;
	Room orderPT;
	Set<Room> children;

	Room(int roomNo) {
		this.roomNo = roomNo;
		visit = false;
		pathPT = null;
		orderPT = null;
		children = new HashSet<>();
	}

	public void setParent(boolean isPath, Room parent) {

		if (parent == null)
			return;

		parent.children.add(this);

		if (isPath)
			this.pathPT = parent;
		else
			this.orderPT = parent;

	}

	public Set<Room> check() {

		if (visit) {
			// 이미 visit이라면 return null
			return null;
		} else {
			// !visit이라면 pathPT/orderPT 확인하여 true인경우 visit = true + return children
			// pathPT/orderPT 확인하여 false인경우 nothing
			visit = pathPT == null || pathPT.visit;
			visit &= orderPT == null || orderPT.visit;
			return visit ? children : null;
		}
	}

	/*
	 * public Set<Room> doVisit() { Set<Room> rst = visit ? null : children; visit =
	 * true; return rst; }
	 */
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("RoomNo:[").append(roomNo).append("], pathPTno:[").append(pathPT != null ? pathPT.roomNo : "-")
				.append("], orderPTno:[").append(orderPT != null ? orderPT.roomNo : "-").append("], ")
				.append("children:[");
		boolean isFirst = true;
		for (Room child : children) {
			if (isFirst) {
				isFirst = false;
			} else {
				sb.append(",");
			}
			sb.append(child.roomNo);
		}
		sb.append("]");
		return sb.toString();
	}
}