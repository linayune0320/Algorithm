package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B10828_스택 {

	static int N;
	static int[] stack;
	static int size = 0;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stack = new int[N];
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			stack(br.readLine());
		}
		System.out.println(sb);

	}

	private static void stack(String command) {
		int ans;
		switch (command) {
		case "pop":
			if (size == 0)
				ans = -1;
			else {
				ans = stack[size - 1];
				size--;
			}
			break;
		case "size":
			ans = size;
			break;
		case "empty":
			if (size <= 0) {
				ans = 1;
			} else {
				ans = 0;
			}
			break;
		case "top":
			if (size <= 0) {
				ans = -1;
			} else {
				ans = stack[size - 1];
			}
			break;

		default:
			StringTokenizer st = new StringTokenizer(command);
			st.nextToken();
			int x = Integer.parseInt(st.nextToken());
			stack[size] = x;
			size++;
			return;
		}

		sb.append(ans + "\n");

	}

}
