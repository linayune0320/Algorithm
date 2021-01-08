package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B2667_단지번호붙이기 {

	static int N ;
	static char map [][] ;
	static int num ;
	static int cnt ; 
	static int dx[] = {0,0,-1,1};//상 하 좌 우 
	static int dy[] = {1,-1,0,0};//상 하 좌 우 
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char [N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j]= s.charAt(j);

			}

		}//입력 완료
		num = 0;
		Queue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='1') {
					num++;
					cnt =0 ;
					takeNum(i,j);
					q.add(cnt);
				}
			}
			
		}
		
		System.out.println(num);
		for (int i = 0; i < num; i++) {
			System.out.println(q.poll());
		}
		

	}
	private static void takeNum(int i, int j) {
		map[i][j]='0';
		cnt ++;
		for (int k = 0; k < 4; k++) {
			int ny = i + dy[k];
			int nx = j + dx[k];
			if(ny>=0&&ny<N&&nx>=0&&nx<N&&map[ny][nx]=='1') {
				takeNum(ny,nx);
			}
			
		}
		
		
	}

}
