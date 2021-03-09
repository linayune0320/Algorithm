package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B9938_방청소 {
	static boolean[] visited;
	static int parent[];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		visited = new boolean[L + 1];
		parent = new int[L + 1];
		for (int i = 0; i < L + 1; i++) {
			parent[i] = i;
		}
		int a, b;
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if (!visited[a]) {
				visited[a] = true;
				union(a, b);
			} else if (!visited[b]) {
				visited[b] = true;
				union(b, a);
			} else if (!visited[find(parent[a])]) {
				visited[find(parent[a])] = true;
				union(a, b);
			} else if (!visited[find(parent[b])]) {
				visited[find(parent[b])] = true;
				union(b, a);
			} else {
				sb.append("SMECE\n");
			}
		}

		System.out.println(sb.toString());
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		parent[a] = b;
		sb.append("LADICA\n");
	}

	private static int find(int a) {
		if (parent[a] == a)
			return a;

		return parent[a] = find(parent[a]);
	}

}
