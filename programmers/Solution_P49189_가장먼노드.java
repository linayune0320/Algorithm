package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_P49189_가장먼노드 {
	public int solution(int n, int[][] edge) {
		int answer = 0;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < edge.length; i++) {
			graph.get(edge[i][0]).add(edge[i][1]);
			graph.get(edge[i][1]).add(edge[i][0]);
		}
		boolean visited[] = new boolean[n + 1];
		visited[1] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		int size = 0;
		int a;
		while (!q.isEmpty()) {
			size = q.size();
			answer = size;
			while (size-- > 0) {
				a = q.poll();
				for (int i = 2; i <= n; i++) {
					if (graph.get(i).contains(a) && !visited[i]) {
						visited[i] = true;
						q.add(i);
					}
				}
			}
		}

		return answer;
	}

}
