package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_S1861_정사각형방 {
	static int N ;
	static int map [][] ;
	static int dy [] = {-1,1,0,0};
	static int dx [] = {0,0,-1,1};
	static int start ;
	static int max; 
	static Queue<Integer> q = new LinkedList<Integer>();  ; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t =1 ; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int [N][N];
			StringTokenizer st;
			start = 0 ;
			max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}// 입력 완료
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i,j);
				}
			}
			System.out.println("#"+t+" "+start+" "+max);
		}

	}
	private static void bfs(int i, int j) {
		if(start!=0&&map[i][j]>start&&map[i][j]<start+max) return;
		int s = map[i][j];
		int cnt = 1; 
		q.add(s);
		while(!q.isEmpty()) {
			int a= q.poll();
			for (int k = 0; k <4; k++) {
				int ny = i + dy[k];
				int nx = j + dx[k];
				if(ny>=0&&nx>=0&&ny<N&&nx<N&&map[ny][nx]==a+1) {
					q.add(map[ny][nx]);
					cnt++;
					i = ny;
					j = nx ; 
					break;
				}
			}
		}
		if(max==cnt&&start>s) {
			start=s ;
		}else if( max < cnt) {
			max = cnt ; 
			start = s ; 
		}

		
	}

}
