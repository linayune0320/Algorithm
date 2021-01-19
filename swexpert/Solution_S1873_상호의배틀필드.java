package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_S1873_상호의배틀필드 {

	static int T ; 
	static int H ,W ;
	static char map[][];
	static int N; 
	static int dy [] = {-1,1,0,0};//상 하 좌 우 
	static int dx [] = {0,0,-1,1};
	static int r; 
	static int c ; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char [H][W];

		char state ; 
		for (int i = 0; i < H; i++) {
			String s = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='^'|| map[i][j]=='v'||map[i][j]=='<'||map[i][j]=='>') {
					 r = i ;
					 c = j ;
				}
			}
		}
		N = Integer.parseInt(br.readLine());
		String command = br.readLine();
		for (int i = 0; i < N; i++) {
			go (command.charAt(i));
		}
		System.out.print("#"+t+" ");
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		}	
	}
	private static void go(char com) {
		switch (com) {
		case 'U':
			map[r][c]='^';
			if(isRange(r-1,c)&&map[r-1][c]=='.') {
				map[r][c] = '.';
				map[r-1][c] = '^';
				r--;
			}
			break;
		case 'D':
			map[r][c]='v';
			if(isRange(r+1,c)&&map[r+1][c]=='.') {
				map[r][c] = '.';
				map[r+1][c] = 'v';
				r++;
			}
			break;
		case 'L':
			map[r][c]='<';
			if(isRange(r,c-1)&&map[r][c-1]=='.') {
				map[r][c] = '.';
				map[r][c-1] = '<';
				c--;
			}
			break;
		case 'R':
			map[r][c]='>';
			if(isRange(r,c+1)&&map[r][c+1]=='.') {
				map[r][c] = '.';
				map[r][c+1] = '>';
				c++;
			}
			break;
		case 'S':
			shoot(r,c);
			break;
		default:
			break;
		}
		
	}
	private static void shoot(int i, int j) {
		int ny , nx ;
		switch (map[i][j]) {
		case '^':
			ny = i; 
			nx = j;
			while(true) {
			 ny += dy[0];
			 nx += dx[0];
			 if(isRange(ny, nx)) {
				 if(map[ny][nx]=='.' || map[ny][nx]=='-') {
					 continue;
				 }else if ( map[ny][nx]=='*') {
					 map[ny][nx] = '.';
				     break;					 
				 }else if (map[ny][nx]=='#') {
					 break;
				 }

			 } else {
				 break;
			 }
			}
			break;
		case '>':   // 상 하 좌 우 
			ny = i; 
			nx = j;
			while(true) {
			 ny += dy[3];
			 nx += dx[3];
			 if(isRange(ny, nx)) {
				 if(map[ny][nx]=='.' || map[ny][nx]=='-') {
					 continue;
				 }else if ( map[ny][nx]=='*') {
					 map[ny][nx] = '.';
				     break;					 
				 }else if (map[ny][nx]=='#') {
					 break;
				 }

			 } else {
				 break;
			 }
			}
			
			break;
		case 'v':
			ny = i; 
			nx = j;
			while(true) {
			 ny += dy[1];
			 nx += dx[1];
			 if(isRange(ny, nx)) {
				 if(map[ny][nx]=='.' || map[ny][nx]=='-') {
					 continue;
				 }else if ( map[ny][nx]=='*') {
					 map[ny][nx] = '.';
				     break;					 
				 }else if (map[ny][nx]=='#') {
					 break;
				 }

			 } else {
				 break;
			 }
			}			
			break;
		case '<':
			ny = i; 
			nx = j;
			while(true) {
			 ny += dy[2];
			 nx += dx[2];
			 if(isRange(ny, nx)) {
				 if(map[ny][nx]=='.' || map[ny][nx]=='-') {
					 continue;
				 }else if ( map[ny][nx]=='*') {
					 map[ny][nx] = '.';
				     break;					 
				 }else if (map[ny][nx]=='#') {
					 break;
				 }

			 } else {
				 break;
			 }
			}			
			break;
		default:
			break;
		}
		
	}
	private static boolean isRange(int i, int j) {
        if(i>=0&&j>=0&&i<H&&j<W) {
        	return true;
        }
		return false;
	}

}
