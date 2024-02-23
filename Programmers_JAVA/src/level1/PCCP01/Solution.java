package level1.PCCP01;

class Solution {
	public int solution(int[] bandage, int health, int[][] attacks) {

		int banding_time = bandage[0], banding_tick = bandage[1],
				banding_fin = banding_time * banding_tick + bandage[2];

		int current_health = health, current_time = 0;

		for (int[] attack : attacks) {
			int banded_time = attack[0] - current_time - 1;
			current_time = attack[0];
			current_health += (banded_time / banding_time) * banding_fin;
			current_health += (banded_time % banding_time) * banding_tick;
			current_health = Math.min(current_health, health);
			current_health -= attack[1];
			if (current_health < 0)
				return -1;
		}
		return current_health;
	}
}