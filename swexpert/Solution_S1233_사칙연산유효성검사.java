package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_S1233_사칙연산유효성검사 {

	static char map [];
	static int N ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <=10; t++) {
			 N = Integer.parseInt(br.readLine());
			map = new char [N+1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				map[i] = st.nextToken().charAt(0);
			}

			System.out.println("#"+t+" "+isCal(N/2));
			
			
		}

	}
	private static boolean isChar(char a) {
		if(a=='+'|| a =='-' || a== '*' || a== '/') {
			return true;
		}
		
		return false;
		
	}
	private static int isCal(int d) {
		
	    	
		for (int i = 1; i <=d; i++) {
			if(!isChar(map[i])) return 0;
			
		}
		for (int i = d+1; i <=N; i++) {
			if(isChar(map[i])) return 0;
		}
		
		return 1 ;
	}

}
