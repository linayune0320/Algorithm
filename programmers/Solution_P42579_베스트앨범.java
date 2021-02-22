package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_P42579_베스트앨범 {

	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		List<Integer> answerQ = new LinkedList<Integer>();
		HashMap<Integer, String> hs = new HashMap<Integer, String>();
		List<Album> alist = new ArrayList<Album>();
		int idx = 0;
		for (int i = 0; i < genres.length; i++) {
			if (!hs.containsValue(genres[i])) {
				hs.put(idx, genres[i]);
				alist.add(new Album(idx, plays[i]));
				idx++;

			} else {
				int key = getKey(hs, genres[i]);
				int value = alist.get(key).plays + plays[i];
				alist.set(key, new Album(key, value));

			} // 장르 갯수 파악

		}

		Collections.sort(alist, new Comparator<Album>() {
			@Override
			public int compare(Album o1, Album o2) {
				return o2.plays - o1.plays;
			}
		});

		for (int i = 0; i < alist.size(); i++) {
			int key = alist.get(i).idx;
			String genre = hs.get(key);
			PriorityQueue<Album> q = new PriorityQueue<Album>(new Comparator<Album>() {

				@Override
				public int compare(Album o1, Album o2) {
					if (o1.plays == o2.plays) {
						return o1.idx - o2.idx;
					}
					return o2.plays - o1.plays;
				}

			});
			for (int j = 0; j < genres.length; j++) {
				if (genres[j].equals(genre)) {
					q.add(new Album(j, plays[j]));

				}
			}
			int cnt = 0;
			while (!q.isEmpty()) {

				answerQ.add(q.poll().idx);
				cnt++;
				if (cnt == 2)
					break;
			}

		}

		answer = new int[answerQ.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = answerQ.get(i);
		}

		return answer;
	}

	public static Integer getKey(HashMap<Integer, String> m, String value) {
		for (Integer o : m.keySet()) {
			if (m.get(o).equals(value)) {
				return o;
			}
		}
		return null;
	}

}

class Album {
	int idx;
	int plays;

	public Album(int idx, int plays) {
		this.idx = idx;
		this.plays = plays;
	}

}
