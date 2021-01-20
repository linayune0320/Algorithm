package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_S1258_행렬찾기 {
	
	static int n ; 
	static int map [][] ;
	static Queue<Matrix> q; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <=T; t++) {
			n  = Integer.parseInt(br.readLine());
			map = new int [n][n];
			 StringTokenizer st;
			for (int i = 0; i <n; i++) {
			    st = new StringTokenizer(br.readLine());
			    for (int j = 0; j <n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}// 입력 완료 
			q = new PriorityQueue<Matrix>(new Comparator<Matrix>() {

				@Override
				public int compare(Matrix o1, Matrix o2) {
					 if(o1.size== o2.size) {
						 return o1.row-o2.row;
					 }else {
						 return o1.size-o2.size;
					 }

				}
				
			});
			
			for (int i = 0; i <n; i++) {
				for (int j = 0; j <n; j++) {
					if(map[i][j]!=0) {
						dfs(i,j);
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			int size = q.size();
			sb.append("#"+t+" "+q.size());
			for (int i = 0; i < size; i++) {
				Matrix sub = q.poll();
				sb.append(" "+sub.row+" "+sub.col);
			}
			
			System.out.println(sb);
			
		}

	}
	private static void dfs(int i, int j) {
		int ny = i;
		int nx = j ;
		while(true) {
			ny++;
			if(ny>=0&&ny<n&&map[ny][j]!=0) {
			}else break;
		}
		
		while(true) {
			nx++;
			if(nx>=0 && nx<n &&map[i][nx]!=0) {
			}else break;
		}
		
		Matrix matrix = new Matrix(ny-i, nx-j, (i-ny)*(j-nx));
		q.add(matrix);
		for (int k = i; k <ny ; k++) {
			for (int l = j; l <nx; l++) {
				map[k][l] =0; // 지나간곳 처리 
			}
		}
		
	}

}
class Matrix {
	int row ; // 행
	int col ; // 열 
	int size ; 
	public Matrix(int row, int col, int size) {
		this.row = row;
		this.col = col;
		this.size = size;
	}
	
}
