package swexpert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_S1225_암호생성기 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <=10; tc++) {
			sc.next();
			Queue <Integer> q = new LinkedList<Integer>(); 
			for (int i = 0; i < 8; i++) {
				q.add(sc.nextInt());
			}
			int num = 1; // 감소해야되는 숫자 
			while (true) {
				int a = q.poll() - num;
				if(a<=0) {
					q.add(0);
					break;
				}
					q.add(a);
					if(num==5) num=1;
					else num++;
	
			}
			String ans = "" ;
			for (int i = 0; i < 8; i++) {
				ans += q.poll() + " ";
				
			}
			System.out.println("#"+tc+" "+ans);
			
		}
		
		

	}

}
