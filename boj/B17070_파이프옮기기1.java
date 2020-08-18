import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17070_파이프옮기기1 {
	static int N ;
	static int map [][] ;
   static int shape[] = {0,1,2}; // 가로, 세로 , 대각선
   static int dy [] = {0,1,1};//가로
   static int dx[] = {1,0,1};//세로 대각선 
   static int result =0;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 map = new int [N][N];
		 //N-1,N-1 의 경우의수  찾기 (0,0)(0,1)부터시작 
		 StringTokenizer st = null;
		 for (int i = 0; i < N;  i++) {
			 st = new StringTokenizer(br.readLine());
			for (int j = 0; j <N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력완료 
		 
		 move(0,0,0); //첫번째파이프 행, 열, 파이프 모양  
		 System.out.println(result);
		 
	}
	private static void move(int prow, int pcol,int shape) {
		if(prow+dy[shape]==N-1 && pcol+dx[shape]==N-1) {
			result ++;
			return ;
		}
		int p2row = prow+dy[shape];
		int p2col = pcol+dx[shape];
		int ny, nx ;
		if(shape==0) { //가로
			//case 1 
			ny = p2row +dy[0];
			nx = p2col +dx[0];
			if(nx<N && map[ny][nx]==0) {
				move(p2row,p2col,0 );
			}
			//case 2 
			ny = p2row+dy[2];
			nx= p2col +dx[2];
			if(ny<N&&nx<N&&map[ny][nx]==0&&map[ny-1][nx]==0&&map[ny][nx-1]==0) {
				move(p2row,p2col,2);
			}
			
		}else if (shape ==1 ) {//세로
			//case 1 
			ny = p2row +dy[1];
			nx = p2col +dx[1];
			if(ny<N && map[ny][nx]==0) {
				move(p2row,p2col,1 );
			}
			//case 2 
			ny = p2row+dy[2];
			nx= p2col +dx[2];
			if(ny<N&&nx<N&&map[ny][nx]==0&&map[ny-1][nx]==0&&map[ny][nx-1]==0) {
				move(p2row,p2col,2);
			}
		}else { //대각선 
			//case 1 
			ny = p2row +dy[0];
			nx = p2col +dx[0];
			if(nx<N && map[ny][nx]==0) {
				move(p2row,p2col,0 );
			}
			//case 2 
			ny = p2row +dy[1];
			nx = p2col +dx[1];
			if(ny<N && map[ny][nx]==0) {
				move(p2row,p2col,1 );
			}
			//case 3 
			ny = p2row+dy[2];
			nx= p2col +dx[2];
			if(ny<N&&nx<N&&map[ny][nx]==0&&map[ny-1][nx]==0&&map[ny][nx-1]==0) {
				move(p2row,p2col,2);
		}
		
		}
		
}
}
