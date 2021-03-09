package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B10775_공항 {

	static boolean[] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int a;
		int cnt = 0;

		map = new boolean[G + 1];
		for (int i = 0; i < P; i++) {
			a = Integer.parseInt(br.readLine());
			boolean flag= false;	
			while(a>=1) {
				if(!map[a]) {
					map[a]=true;
					cnt++;
					flag= true;
					break;
				}
				a--;
			}
			
			if(!flag) {
			 break;
		  	}
		}
		
		System.out.println(cnt);

	}

}
