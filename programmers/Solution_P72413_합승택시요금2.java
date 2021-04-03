package programmers;

public class Solution_P72413_합승택시요금2 {

	public int solution(int n, int s, int a, int b, int[][] fares) {
		/*
		 * 모든 정점에서 정점까지 최단거리 : 플로이드 와샬 알고리즘 (n^3)
		 */
		int map[][] = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					map[i][j] = 0;
				else {
					map[i][j] = Integer.MAX_VALUE;
				}

			}

		}
		for (int i = 0; i < fares.length; i++) {
			map[fares[i][0]][fares[i][1]] =fares[i][2];
			map[fares[i][1]][fares[i][0]] =fares[i][2];
		}
		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <=n; j++) {
				for (int k = 1; k <=n; k++) {
					if(map[j][i]== Integer.MAX_VALUE || map[i][k]==Integer.MAX_VALUE) {
						continue;
					}
					map[j][k] =Math.min(map[j][k], map[j][i] + map[i][k]); 
				}
			}
		}
		 
		int answer = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
		}

		return answer;
	}

}
