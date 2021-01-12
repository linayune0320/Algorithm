package boj;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_B2609_최대공약수와최소공배수 {
	
	static LinkedList<Integer> aList = new LinkedList<Integer>();
	static LinkedList<Integer> bList = new LinkedList<Integer>();
    static int max ;  
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		max =1 ; 
		maxa(a);
		maxb(b);
		while(!aList.isEmpty()) {
			int x = aList.pop();
			if(bList.contains(x)) {
				max *= x ;
				bList.removeFirstOccurrence(x);
			}
		}
		
		System.out.println(max); //최대공약수
		System.out.println(a*b/max);//최소공배수 
	  	

	}

	private static void maxa(int n) {
		
		int i =2 ;
		while((n%i)!=0 && i<=n) {
			i++;
		}
		
		if(i<=n) {
			aList.add(i);
			maxa(n/i);
		}
		
		
	}
	
	private static void maxb(int n) {
		
		int i =2 ;
		while((n%i)!=0 && i<=n) {
			i++;
		}
		
		if(i<=n) {
			bList.add(i);
			maxb(n/i);
		}
		
	}

}
