package boj;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B7576_토마토 {

	static int M;
	static int N;
	static int count;
	static int farm[][];
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	static Queue<Point> q = new LinkedList<Point>();
	static int day = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		farm = new int[N][M];
		/* 익은 토마토 1 안익은토마토 0 없으면 -1 */
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				farm[i][j] = Integer.parseInt(st.nextToken());
				if (farm[i][j] == 0)
					count++; // 안익은 토마토의 수
				else if (farm[i][j] == 1) {
					q.offer(new Point(j, i));
				}

			}
		}

		if (count == 0) {
			System.out.println(0);// 처음부터 안익은 토마토가 없을 때
			return;
		}

		bfs();
		if (count > 0)
			System.out.println(-1);
		else {
			System.out.println(day);
		}

	}

	private static void bfs() {
		int size = 0;
		while (!q.isEmpty()) {

			size = q.size();
			while (size-- > 0) {
				Point e = new Point();
				e = q.poll();
				for (int k = 0; k < 4; k++) {
					int nextx = e.x + dx[k];
					int nexty = e.y + dy[k];

					if (nextx >= 0 && nextx < M && nexty >= 0 && nexty < N) {
						if (farm[nexty][nextx] == 0) {
							farm[nexty][nextx] = 1;
							count--;
							q.offer(new Point(nextx, nexty));
						}
					}
				}
			}
			day++;
			if (count <= 0) {
				return;
			}

		}

	}

}
