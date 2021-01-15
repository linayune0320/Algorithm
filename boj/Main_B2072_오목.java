package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2072_오목 {

	static int map[][];
	static int cnt;
	static int N;
	static int dy[] = { -1, -1, 0, 1 }; // 상,상우, 우,하우
	static int dx[] = { 0, 1, 1, 1 };// 상,상우, 우,하우

	public static void main(String[] args) throws NumberFormatException, IOException {

		map = new int[20][20]; // 1-19
		cnt = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x, y;
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map[y][x] = i % 2 == 0 ? 1 : -1; // 흑 : -1 , 백 : 1
			int turn = map[y][x];
			for (int d = 0; d < 4; d++) {
				if (check(y, x, turn, d, 1) == 5) {
					cnt = i;
					System.out.println(cnt);
					return;
				}
			}

		}

		System.out.println(cnt);
	}

	private static int check(int y, int x, int turn, int d, int num) {
		int ny = y;
		int nx = x;
		while (true) {
			ny += dy[d];
			nx += dx[d];
			if (ny >= 1 && nx >= 1 && ny < 20 && nx < 20 && map[ny][nx] == turn) {
				num++;
			} else {
				break;
			}
		}

		ny = y;
		nx = x;
		while (true) {
			ny -= dy[d];
			nx -= dx[d];
			if (ny >= 1 && nx >= 1 && ny < 20 && nx < 20 && map[ny][nx] == turn) {
				num++;
			} else {
				break;
			}
		}
		return num;

	}

}
