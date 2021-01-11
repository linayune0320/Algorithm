package swexpert;

import java.util.Scanner;
import java.util.Stack;

public class Solution_S5432_쇠막대기자르기 {
	static int T ; 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String s = sc.next();
			Stack<Character> stack = new Stack<Character>();
			int size = s.length(); // (레이저 + 초기 쇠막대기 갯수)*2 
			int raiser = 0 ; // 레이저 갯수 
			int cut = 0 ;// 잘려서 추가된 쇠막대기 갯수 
			int result =0; 
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)=='(') {
					stack.push('(');
				}else {
					if(s.charAt(i-1)=='(') {
						//레이저 
						raiser++;
						stack.pop();
						cut += stack.size();
					}else {
						stack.pop();
					}
					
					
				}
			}
			
			size = (size/2)-raiser ;  // 초기 쇠막대기 갯수 
			result = size+cut; //  초기 막대기갯수 + 잘린 쇠막대기 
			System.out.println("#"+t+" "+result);
		}
		

	}

}
