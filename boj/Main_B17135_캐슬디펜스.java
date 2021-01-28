package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B17135_캐슬디펜스 {

	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int[] dx = { 0, -1, 0 };
	public static int[] dy = { -1, 0, 1 };
	public static int N, M, D, ans = 0;
	public static boolean[] visit; // nCr 구할 때 사용하는 배열
	public static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];
		visit = new boolean[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(0, 0);
		System.out.println(ans);
	}

	// mC3 궁수자리선택
	public static void combination(int idx, int cnt) {
		if (cnt == 3) {
			int[][] nmap = new int[N + 1][M];
			for (int i = 0; i < N + 1; i++) {
				for (int j = 0; j < M; j++) {
					nmap[i][j] = map[i][j];
				}
			}
			bfs(nmap);
			return;
		}
		for (int i = idx; i < M; i++) {
			if (!visit[i]) {
				visit[i] = true;
				combination(i, cnt + 1);
				visit[i] = false;
			}
		}
	}

	public static void bfs(int[][] nmap) {
		int cnt = 0;
		for (int i = N; i > 0; i--) { // 궁수 한칸씩 이동
			int archerIdx = 0;
			Queue<Pos> q = new LinkedList<>();
			for (int j = 0; j < M; j++) {

				if (visit[j]) {
					nmap[i][j] = 2;
					q.add(new Pos(i - 1, j, 1, archerIdx++));
				} else { // 궁수 위치가 아니면 0
					nmap[i][j] = 0;
				}
			}

			boolean[] isFindEnemy = new boolean[3]; // 각 궁수가 몬스터를 찾았는지
			boolean[][][] visited = new boolean[N][M][3]; // 각 궁수가 해당 좌표를 방문했는지
			boolean[][] isOverlap = new boolean[N][M]; // 이미 다른궁수의 몬스터와 겹쳤는지 
			ArrayList<Pos> alist = new ArrayList<>();

			while (!q.isEmpty()) {
				Pos p = q.poll();
				if (isFindEnemy[p.idx])
					continue;
				if (nmap[p.x][p.y] == 1) {
					isFindEnemy[p.idx] = true;
					if (!isOverlap[p.x][p.y]) {
						isOverlap[p.x][p.y] = true;
						alist.add(p);
						cnt++;
					}
					continue;
				}
				if (!isFindEnemy[p.idx]) {
					visited[p.x][p.y][p.idx] = true;
					for (int j = 0; j < 3; j++) {
						int nx = p.x + dx[j];
						int ny = p.y + dy[j];
						if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny][p.idx] && p.depth < D) {
							q.add(new Pos(nx, ny, p.depth + 1, p.idx));
						}
					}
				}
			}
			for (int j = 0; j < alist.size(); j++) {
				Pos p = alist.get(j);
				nmap[p.x][p.y] = 0;
			}
		}
		ans = Math.max(ans, cnt);
	}

	public static class Pos {
		int x, y, depth, idx;

		public Pos(int x, int y, int depth, int idx) {
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.idx = idx;
		}
	}

}
