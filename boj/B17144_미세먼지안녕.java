package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17144_미세먼지안녕_윤지원 {
	
	static int R,C,T;
	static int map[][][];
	static int airCleanerUp;//위에있는 공기청정기위치
	static int airCleanerDown;//밑에 있는 공기청정기 위치 
	static int dy [] = {1,-1,0,0};//상,하, 좌, 우  
	static int dx [] = {0,0,-1,1};//상,하, 좌, 우
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int [R][C][3];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j][0]= Integer.parseInt(st.nextToken());
			}
		} // 입력 완료 
		

		for (int i = 0; i < R; i++) {
			if(map[i][0][0]==-1) {
				airCleanerUp = i;
				airCleanerDown = i+1;
				break;
			}
		}//공기청정기 위치 찾기 (i,0)
		for (int i = 0; i < T; i++) {
			//미세먼지 작동 
			airMove();

			//공기청정기 작동 
			cleanAir();
			
		}
		//총 남아있는 미세먼지 구하기 
		int total=0;
		for (int i = 0; i <R; i++) {
			for (int j = 0; j <C; j++) {
				if(map[i][j][0]>0) {
					total+= map[i][j][0];
				} 
			}
		}

		System.out.println(total);
	}

	
	private static void airMove() {
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j][0]>0) {//미세먼지가 존재한다면 
						int ny, nx ; 
						int dir =0; //확산된 갯수 
						for (int k = 0; k < 4; k++) {
							ny = i + dy[k];
							nx = j+ dx[k];
							if(ny<0 || ny>=R || nx<0 || nx>=C || map[ny][nx][0]==-1) { //공기청정기위치거나 칸이 존재하지 않는경우 
								continue;
							}
							dir ++; //확산된 영역 갯수 
							map[ny][nx][1] += map[i][j][0]/5; //미세먼지 확산
						}
						map[i][j][2] = dir; //확산된 영역 갯수 
				}
			}
		}// 확산완료 
		
		//확산후 미세먼지양 계산 
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int dist =map[i][j][0]; 
				map[i][j][0] = dist - ((dist/5)*map[i][j][2]);//남은 미세먼지 계산 
				map[i][j][0]+=map[i][j][1];
				map[i][j][1]=0; // 초기화
				map[i][j][2]=0; // 초기화 
			  }
			}
		
	}
	
	private static void cleanAir() {
		Queue<Integer> q = new LinkedList<Integer>(); // 상 하 좌 우 
													  // 0 1 2 3 
		//위쪽 공기 반시계방향  우 -> 상 -> 좌 -> 하           


		q.add(map[airCleanerUp][1][0] );
		map[airCleanerUp][1][0]=0;
		for (int  c = 2; c <C; c++) { //우
			q.add(map[airCleanerUp][c][0] ); //큐에 집어넣기 
			map[airCleanerUp][c][0] = q.poll(); //이전 미세먼지 집어넣기 
		}
		for (int i = airCleanerUp-1; i >=0; i--) {//상
			q.add(map[i][C-1][0]);
			map[i][C-1][0] = q.poll();
		}
		
		for (int c = C-2; c >=0; c--) {//좌
			q.add(map[0][c][0]);
			map[0][c][0] = q.poll();
		}
		
		for (int r = 1; r <airCleanerUp; r++) {//하
			q.add(map[r][0][0]);
			map[r][0][0] = q.poll();
		}
		q.clear();
		
		//아래쪽 공기 시계방향  우 -> 하 -> 좌 -> 상 

		q.add(map[airCleanerDown][1][0]);
		map[airCleanerDown][1][0]=0;
		
		for (int  i = 2; i <C; i++) { //우
			q.add(map[airCleanerDown][i][0] ); //큐에 집어넣기 
			map[airCleanerDown][i][0] = q.poll(); //이전 미세먼지 집어넣기 
		}
		for (int i = airCleanerDown+1; i <R; i++) {//하
			q.add(map[i][C-1][0]);
			map[i][C-1][0] = q.poll();
		}
		
		for (int i = C-2; i >=0; i--) {//좌
			q.add(map[R-1][i][0]);
			map[R-1][i][0] = q.poll();
		}
		for (int i = R-2; i >airCleanerDown; i--) {//상
			q.add(map[i][0][0]);
			map[i][0][0] = q.poll();
		}
		
		
		
	}
		
}
