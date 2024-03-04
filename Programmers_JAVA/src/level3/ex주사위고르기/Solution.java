package level3.ex주사위고르기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Solution {

	int length, value;
	int[] answer;

	public int[] solution(int[][] dice) {

		length = dice.length;
		value = 0;
		answer = new int[length / 2];

		pickDice(dice, new Stack<>(), new Stack<>(), 0, new int[length / 2]);

		return answer;
	}

	private void pickDice(int[][] dice, Stack<int[]> picked, Stack<int[]> unpicked, int index, int[] pick) {

		if (index < length) {

			if (picked.size() < length / 2) {
				pick[picked.size()] = index + 1;
				picked.add(dice[index]);
				pickDice(dice, picked, unpicked, index + 1, pick);
				picked.pop();
			}

			if (unpicked.size() < length / 2) {
				unpicked.add(dice[index]);
				pickDice(dice, picked, unpicked, index + 1, pick);
				unpicked.pop();
			}

		} else {

			int countWin = countPickedWin(picked, unpicked);

			if (countWin > value) {
				value = countWin;
				answer = pick.clone();
			}

		}

	}

	private int countPickedWin(Stack<int[]> picked, Stack<int[]> unpicked) {

		List<Integer> pickedCase = new ArrayList<>();
		List<Integer> unpickedCase = new ArrayList<>();

		allCases(picked, pickedCase, 0);
		allCases(unpicked, unpickedCase, 0);

		Collections.sort(pickedCase);
		Collections.sort(unpickedCase);

		int count = 0;

		for (int pick : pickedCase) {

			int left = -1, right = unpickedCase.size();
			while (left + 1 < right) {
				int mid = (left + right) / 2;
				if (unpickedCase.get(mid) < pick)
					left = mid;
				else
					right = mid;
			}
			count += right;

		}

		return count;
	}

	private void allCases(Stack<int[]> diceStack, List<Integer> cases, int value) {

		if (!diceStack.isEmpty()) {
			int[] dice = diceStack.pop();
			for (int val : dice) {
				allCases(diceStack, cases, value + val);
			}
			diceStack.add(dice);
		} else {
			cases.add(value);
		}

	}

}