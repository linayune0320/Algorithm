package swexpert;

import java.util.Scanner;

public class Solution_S1493_수의새로운연산 {
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		
		for (int t = 1; t <=T; t++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			System.out.println("#"+t+" "+pos(p,q));
			}

	}
	private static int pos(int p , int q ) {
	    Point posP; 
		Point posQ;
		int n =1 ;
		int d = 0;
		while(true) {
			if(p<=n*(n+1)/2) {
				d = n*(n+1)/2 - p ;
				posP = new Point(n-d,1+d);
				break;
			}else {
				n++;
			}
		}
		
		 n =1 ;
		 d = 0;
		while(true) {
			if(q<=n*(n+1)/2) {
				d = n*(n+1)/2 - q ;
				posQ = new Point(n-d,1+d);
				break;
			}else {
				n++;
			}
		}
		
		int nx = posQ.x+posP.x;
		int ny = posQ.y+posP.y;
		n = nx+ny-1;
		int result = n*(n+1)/2 - (n-nx);
		return result;
		
		
	} 
	
	

}
class Point {
	int x ;
	int y ;
	public Point(int x , int y) {
		this.x = x;
		this.y = y ;
	}
}
