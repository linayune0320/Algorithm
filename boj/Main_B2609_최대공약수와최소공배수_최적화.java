package boj;

import java.util.Scanner;

public class Main_B2609_최대공약수와최소공배수_최적화 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int  a = sc.nextInt();
		int  b = sc.nextInt();
		int max = -1; 
		for (int i = 1; i <=Math.min(a,b); i++) {
			 if (a%i==0 && b%i==0) {
				 if(max<i) {
					 max = i ;
				 }
			 }
		}
		
		System.out.println(max);
		System.out.println(a*b/max);

	}

}
