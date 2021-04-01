package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution_P72411_메뉴리뉴얼 {
	/*
	 * 1. 조합을 만든다 nCr 2. 모든 조합을 hashmap 에 저장한다. (중복 방지) 3. 가장 많이 선택된 조합을 hashmap에서
	 * 꺼낸다 .
	 * 
	 */
	static HashMap<String, Integer> map; // <key,value> key를 String으로 잡으면 된다. !!! 개꿀 !!
	static int maxCount;

	public String[] solution(String[] orders, int[] course) {
		String[] answer;

		for (int i = 0; i < orders.length; i++) {
			char orderArr[] = orders[i].toCharArray();
			Arrays.sort(orderArr);
			orders[i] = String.valueOf(orderArr);
		}

		PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		for (int i = 0; i < course.length; i++) { // 각각의 요리 개수
			map = new HashMap<>();
			maxCount = 0;
			for (int j = 0; j < orders.length; j++) {
				find(course[i], orders[j], 0, "", orders);
			} // 메뉴를 고를수 있는 조합 다 찾기

			// 2.조합중에서 최대값 찾기
			for (String s : map.keySet()) {
				if (map.get(s) == maxCount && maxCount > 1) { // 두명이상의 조합이어야됨
					pq.add(s);
				}
			}

		}

		answer = new String[pq.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = pq.poll();
		}

		return answer;
	}

	private void find(int n, String menu, int idx, String choice, String[] orders) {
		if (menu.length() < n)
			return;
		if (choice.length() > n)
			return;
		if (idx == menu.length()) {
			if (choice.length() == n) {
				char[] a = choice.toCharArray();
				Arrays.sort(a);
				choice = "";
				for (int i = 0; i < a.length; i++) {
					choice += a[i];
				}
				if (!map.containsKey(choice)) {
					map.put(choice, 1);

				} else {
					map.put(choice, map.get(choice) + 1);
				}
				maxCount = Math.max(map.get(choice), maxCount);
			}
			return;
		}

		find(n, menu, idx + 1, choice + menu.charAt(idx), orders); // 선택
		find(n, menu, idx + 1, choice, orders); // 선택 X

	}
}
