package level1.PCCP01;

class Solution {
	public int solution(int[] bandage, int health, int[][] attacks) {

		int time = 0, maxHealth = health;

		for (int[] attack : attacks) {
			int term = attack[0] - time - 1;
			time = attack[0];
			health += term * bandage[1];
			health += term / bandage[0] * bandage[2];
			health = Math.min(health, maxHealth);
			health -= attack[1];
			if (health <= 0)
				return -1;
		}

		return health;
	}
}