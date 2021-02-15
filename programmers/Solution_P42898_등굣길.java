package programmers;

public class Solution_P42898_등굣길 {

	public int solution(int m, int n, int[][] puddles) {
		int map[][] = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = 1;
			}
		}
		for (int i = 0; i < puddles.length; i++) {
			map[puddles[i][0]][puddles[i][1]] = 0;

		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1 && j == 1)
					continue;
				if (map[i][j] != 0) {
					map[i][j] = (map[i - 1][j] + map[i][j - 1]) % 1000000007;
				}
			}
		}
		return map[m][n];
	}

}
