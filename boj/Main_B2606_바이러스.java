package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2606_바이러스 {
	static int N;
	static int map[][];
	static boolean virus[];
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		int M = Integer.parseInt(br.readLine());
		int a, b;
		StringTokenizer st;
		virus = new boolean[N + 1];
		cnt = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		} // 입력 완료
		virus[1] = true;
		dfs(1);
		System.out.println(cnt);
	}

	private static void dfs(int i) {
		for (int j = 1; j <= N; j++) {
			if (map[i][j] == 1 && !virus[j]) {
				virus[j] = true;
				cnt++;
				dfs(j);
			}
		}
	}

}
