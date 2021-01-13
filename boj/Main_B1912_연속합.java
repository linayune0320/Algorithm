package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1912_연속합 {

	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int map[] = new int[n];
		int minMap[] = new int[n];
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			sum += Integer.parseInt(st.nextToken());
			map[i] = sum;
			if (sum > max)
				max = sum;
			if (min > sum) {
				minMap[i] = sum;
				min = sum;
			} else {
				minMap[i] = min;
			}
		}

		for (int i = n - 1; i > 0; i--) {
			int x = map[i];
				if (x - minMap[i-1] > max)
					 max = x-minMap[i-1];

		}

		System.out.println(max);

	}

}
