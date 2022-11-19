package level2.ex두큐합같게만들기;

class Solution {
	public int solution(int[] queue1, int[] queue2) {

		int idx1 = 0, idx2 = 0;
		long dif = 0, fullLength = queue1.length + queue2.length;

		for (int i = 0; i < queue1.length; i++)
			dif += queue1[i] - queue2[i];

		dif /= 2;

		while (dif != 0 && idx1 < fullLength && idx2 < fullLength) {

			if (dif > 0) {
				dif -= idx1 < queue1.length ? queue1[idx1] : queue2[idx1 - queue1.length];
				idx1++;
			} else {
				dif += idx2 < queue2.length ? queue2[idx2] : queue1[idx2 - queue2.length];
				idx2++;
			}

		}

		return dif == 0 ? (idx1 + idx2) : -1;
	}
	
	public static void main(String[] args) {
		
		int[] arr1 = new int[300000], arr2 = new int[300000];
		for(int i = 0 ; i<arr1.length ; i++) {
			arr1[i] = 1;arr2[i] = 1;
		}
		arr2[299998] = 599999;
		
		System.out.println(new Solution().solution(arr1, arr2));
		
	}
	
}