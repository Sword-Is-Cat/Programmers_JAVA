package level1.ex달리기경주;

import java.util.HashMap;

class Solution {
	public String[] solution(String[] players, String[] callings) {

		RacingNode root = new RacingNode(), node = root;
		HashMap<String, RacingNode> map = new HashMap<>();

		for (String player : players) {
			node.next = new RacingNode(player, node);
			node = node.next;
			map.put(player, node);
		}

		RacingNode[] arr = new RacingNode[4];

		for (String call : callings) {
			RacingNode runner = map.get(call);
			arr[0] = runner.prev.prev;
			arr[1] = runner;
			arr[2] = runner.prev;
			arr[3] = runner.next;

			arr[0].next = arr[1];
			arr[1].next = arr[2];
			arr[2].next = arr[3];

			arr[1].prev = arr[0];
			arr[2].prev = arr[1];
			if (arr[3] != null)
				arr[3].prev = arr[2];

		}

		int idx = 0;
		root = root.next;

		while (root != null) {
			players[idx++] = root.name;
			root = root.next;
		}

		return players;
	}
}

class RacingNode {

	RacingNode prev, next;
	String name;

	RacingNode() {
	}

	RacingNode(String name) {
		this.name = name;
	}

	RacingNode(String name, RacingNode prev) {
		this(name);
		this.prev = prev;
	}

}