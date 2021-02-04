package programmers;

import java.util.Arrays;

public class Solution_체육복 {
	// https://programmers.co.kr/learn/courses/30/lessons/42862#
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		boolean visit[] = new boolean[reserve.length];
		boolean visitLost[] = new boolean[lost.length];
		Arrays.sort(reserve);
		Arrays.sort(lost);

		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] == reserve[j]) {
					answer++;
					visit[j] = true;
					visitLost[i] = true;
					break;
				}
			}
		}
		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (Math.abs(lost[i] - reserve[j]) == 1 && !visit[j] && !visitLost[i] ) {
					answer++;
					visit[j] = true;
					break;

				}
			}
		}

		return n - lost.length + answer;
	}

}
