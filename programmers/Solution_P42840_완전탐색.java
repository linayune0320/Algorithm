package programmers;

import java.util.*;

class Solution_P42840_완전탐색 {
	public int[] solution(int[] answers) {
		int[] answer;
		int a = 0;
		int b = 0;
		int[] bArr = { 1, 3, 4, 5 };
		int[] cArr = { 3, 1, 2, 4, 5 };
		int c = 0;
		for (int i = 0; i < answers.length; i++) {
			if (i % 5 + 1 == answers[i]) {
				a++;
			}
			if (i % 2 == 0) { // 짝수
				if (answers[i] == 2)
					b++;
			} else { // 홀수
				if (bArr[(i % 8) / 2] == answers[i]) {
					b++;
				}
			}

			if (cArr[(i % 10) / 2] == answers[i]) {
				c++;
			}

		}

		int max = Math.max(Math.max(a, b), c);
		List<Integer> list = new ArrayList<Integer>();

		if (a == max) {
			list.add(1);
		}
		if (b == max) {
			list.add(2);
		}
		if (c == max) {
			list.add(3);
		}
		answer = new int[list.size()];
		for (int j = 0; j < list.size(); j++) {
			answer[j] = list.get(j);
		}
		return answer;
	}
}
