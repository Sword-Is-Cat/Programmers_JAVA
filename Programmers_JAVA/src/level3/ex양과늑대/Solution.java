package level3.ex양과늑대;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int solution(int[] info, int[][] edges) {

		Animal[] animals = new Animal[info.length];
		boolean[] able = new boolean[info.length];

		for (int i = 0; i < info.length; i++) {
			animals[i] = new Animal(i, info[i]);
		}

		for (int[] edge : edges) {
			animals[edge[0]].children.add(animals[edge[1]]);
		}

		able[0] = true;

		return dfs(animals, able, 0, 0);
	}

	int dfs(Animal[] animals, boolean[] able, int sheepCnt, int wolfCnt) {

		int result = sheepCnt;

		for (int i = 0; i < animals.length; i++) {

			if (able[i]) {

				Animal animal = animals[i];

				able[i] = false;

				for (Animal child : animals[i].children) {
					able[child.no] = true;
				}

				if (animal.isSheep) {
					result = Math.max(result, dfs(animals, able, sheepCnt + 1, wolfCnt));
				} else {
					if (sheepCnt > wolfCnt + 1)
						result = Math.max(result, dfs(animals, able, sheepCnt, wolfCnt + 1));
				}

				for (Animal child : animals[i].children) {
					able[child.no] = false;
				}

				able[i] = true;

			}

		}

		return result;
	}
}

class Animal {

	int no;
	boolean isSheep;
	Set<Animal> children = new HashSet<>();
	int sheepCnt = -1;

	Animal(int no, int val) {
		this.no = no;
		isSheep = val == 0;
	}

	int sheepCnt() {
		if (sheepCnt == -1) {
			sheepCnt = isSheep ? 1 : 0;
			for (Animal child : children)
				sheepCnt += child.sheepCnt();
		}
		return sheepCnt;
	}

}