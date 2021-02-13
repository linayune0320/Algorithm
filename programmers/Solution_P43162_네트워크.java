package programmers;

public class Solution_P43162_네트워크 {

	static int parents[];

	public int solution(int n, int[][] computers) {
		int answer = 0;
		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = -1;
		}
		for (int i = 0; i < computers.length; i++) {
			for (int j = 0; j < computers[i].length; j++) {
				if (computers[i][j] == 1 && i != j) {
					int parentI = findParent(i);
					int parentJ = findParent(j);
					if (parentI != parentJ) {
						parents[parentI] = parentJ;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (parents[i] == -1)
				answer++;
		}

		return answer;
	}

	public int findParent(int i) {
		if (parents[i] == -1)
			return i;
		return findParent(parents[i]);
	}

}
