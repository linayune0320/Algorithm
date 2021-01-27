package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_S3289_서로소집합 {
	static int[] parents;
	static int command;
	static int a;
	static int b;
	static int aRoot;
	static int bRoot;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parents = new int[n + 1];
			Arrays.fill(parents, -1);// make-set
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				command = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				aRoot = find_set(a);
				bRoot = find_set(b);
				if (command == 0) {
					if (aRoot != bRoot) {
						union_set(aRoot, bRoot);
					}
				} else {
					if (aRoot != bRoot) {
						sb.append("0");
					} else {
						sb.append("1");
					}
				}
			}
			System.out.println("#" + t + " " + sb.toString());
		} // test-case

	}

	static int find_set(int a) {
		if (parents[a] == -1)
			return a;
		return parents[a] = find_set(parents[a]);
	}

	static void union_set(int aRoot, int bRoot) {

		if (aRoot != bRoot) {
			parents[bRoot] = aRoot;
		}
	}

}
