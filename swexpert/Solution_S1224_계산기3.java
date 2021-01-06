package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_S1224_계산기3 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		for (int tc = 1; tc <= 10; tc++) {

			int num = Integer.parseInt(br.readLine());
			char[] token = br.readLine().toCharArray();
			StringBuilder st = new StringBuilder();
			for (int i = 0; i < num; i++) {
				if (Character.isDigit(token[i])) {
					st.append(token[i]);
				} else if (token[i] == ')') {
					while (!stack.isEmpty() && stack.peek() != '(') {
						st.append(stack.pop());
					}
					stack.pop();// 왼쪽 괄호 pop
				} else {
					if (!stack.isEmpty() && (getPriority(token[i], false) > getPriority(stack.peek(), true))) {
						stack.push(token[i]);
					} else {
						while (!stack.isEmpty() && stack.peek() != ')'
								&& getPriority(token[i], false) <= getPriority(stack.peek(), true)) {
							st.append(stack.pop());
						}
						stack.push(token[i]);
					}
				}

			}
			while (!stack.isEmpty()) {
				st.append(stack.pop());
			}
			//System.out.println(st);
			Stack<Integer> cal = new Stack<>();
			for(int i=0; i<st.length();i++) {
				if(Character.isDigit(st.charAt(i))){
					cal.push(st.charAt(i)-'0');
				}
				else {
					int b =cal.pop();
					int a =cal.pop();
					int result=0;
					switch(st.charAt(i)) {
					case '+': result=a+b;
						break;
					case '-': result =a-b;
						break;
					case '/': result =a/b;
						break;
					case '*':result =a*b;
						break;
					}
					cal.push(result);
				}
			}
			System.out.println("#"+tc+" "+cal.pop());
			
		}
	}

	private static int getPriority(char c, boolean isISP) {
		if (isISP) {
			switch (c) {
			case '*':
			case '/':
				return 2;
			case '+':
			case '-':
				return 1;
			case '(':
				return 0;
			default:
				return 0;
			}
		} else {
			switch (c) {
			case '*':
			case '/':
				return 2;
			case '+':
			case '-':
				return 1;
			case '(':
				return 3;
			default:
				return 0;
			}

		}
	}
}
