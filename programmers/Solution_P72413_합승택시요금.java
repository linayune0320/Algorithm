package programmers;

public class Solution_P72413_합승택시요금 {
	/*
	 * 모든 정점에서 정점으로 가는 최소값 구하기 : 플로이드 와샬 알고리즘 (0^3)
	 */

	public int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = Integer.MAX_VALUE;

		int map[][] = new int[n + 1][n + 1]; // 인접행렬
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != j) {
					map[i][j] = Integer.MAX_VALUE;
				} else {
					map[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < fares.length; i++) {
			map[fares[i][0]][fares[i][1]] = fares[i][2];
			map[fares[i][1]][fares[i][0]] = fares[i][2];
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {

					if (map[i][k] == Integer.MAX_VALUE || map[k][j] == Integer.MAX_VALUE)
						continue;
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		} // 플로이드 와샬 알고리즘

		for (int i = 1; i <= n; i++) {
			if (map[s][i] == Integer.MAX_VALUE || map[i][a] == Integer.MAX_VALUE || map[i][b] == Integer.MAX_VALUE)
				continue;

			answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
		}

		return answer;
	}

}
