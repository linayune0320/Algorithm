package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_P42861_섬연결하기 {
	static int[] parent;

	public int solution(int n, int[][] costs) {
		int answer = 0;
		parent = new int[n];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}
		Queue<Bridge> q = new PriorityQueue<Bridge>(new Comparator<Bridge>() {
			@Override
			public int compare(Bridge o1, Bridge o2) {
				return o1.cost - o2.cost;
			}
		});

		for (int i = 0; i < costs.length; i++) {
			q.add(new Bridge(costs[i][0], costs[i][1], costs[i][2]));
		}
		int cnt = 0;
		while (cnt < n && !q.isEmpty()) {
			Bridge b = q.poll();
			int parentI = findParent(b.i);
			int parentJ = findParent(b.j);
			if (parentI != parentJ) {
				parent[parentI] = parentJ;
				answer += b.cost;
				cnt++;
			}
		}

		return answer;

	}

	private int findParent(int i) {
		if (parent[i] == -1) {
			return i;
		}
		return findParent(parent[i]);
	}

}

class Bridge {
	int i;
	int j;
	int cost;

	public Bridge(int i, int j, int cost) {
		this.i = i;
		this.j = j;
		this.cost = cost;
	}
}
