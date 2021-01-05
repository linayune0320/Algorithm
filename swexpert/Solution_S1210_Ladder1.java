package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_S1210_Ladder1 {

	static int[] dy= {0,0,-1}; // 좌,우,상 
	static int[] dx = {-1,1,0}; // 좌,우,상
	static int ans ; 
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t < 11; t++) {
			br.readLine();
			ans = 0;
			map = new int [100][100];
			int start = 0 ; 
			for (int i = 0; i < 100 ; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100 ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i==99&&map[i][j]==2) {
						start = j;
					}
				}
			} // 입력완료
			

			int y = 99;
			int x = start; 	
			int nx = x ; 
			int ny = y; 
			while (true) { 
				
				for (int d = 0; d <3; d++) { // 좌, 우 , 상 
					nx = x + dx[d];
					ny = y + dy[d];
					if(nx>=0&&nx<100&&ny>=0&&ny<100&&map[ny][nx]==1) {
						x=  nx ;
						y = ny ;
						map[ny][nx]=0; // 지나간길 체크 
					    break;
					}					
					
				}
				if(y == 0 ) break; // y가 최상단일때 break; 
				
			}
			
			ans = nx; 
			System.out.println("#"+t+" "+ans);
		}
		
		
		

	}

}
