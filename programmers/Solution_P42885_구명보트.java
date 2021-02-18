package programmers;

import java.util.Arrays;

public class Solution_P42885_구명보트 {

	public int solution(int[] people, int limit) {
		Arrays.sort(people);
		int answer = 0;
		int idx = people.length-1;
		for (int i = 0; i <= idx; i++ , answer++) {
			while(idx >i && people[i] + people[idx--] > limit) {
				answer++;
			}
		}

		return answer;
	}

}
