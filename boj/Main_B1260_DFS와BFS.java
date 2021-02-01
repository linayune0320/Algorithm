package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B1260_DFS와BFS {

	static int N ,M ;
	static int map [][];
	static boolean visited[];
	static StringBuilder bf = new StringBuilder();
	static StringBuilder df = new StringBuilder();
	static Queue<Integer> q = new LinkedList<Integer>(); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	   int V  = Integer.parseInt(st.nextToken());
	   map = new int [N+1][N+1];
	   visited = new boolean[N+1]; 
	   int a,b ;
	   for (int i = 0; i < M; i++) {
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		map[a][b]=1;
		map[b][a]=1;
		
	}
	   
	   q.add(V);
	   visited[V]=true;
	   bf.append(V);
	   df.append(V);
	   bfs();
	   visited = new boolean[N+1]; 
	   visited[V]=true;
	   dfs(V);
	   System.out.println(df.toString());
	   System.out.println(bf.toString());
	   
		

	}
	private static void dfs(int v) {

		for (int i = 1; i <=N; i++) {
			if(map[v][i]==1&&!visited[i]) {
				visited[i]=true;
				df.append(" "+i);
				dfs(i);
			}
		}
		
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int v = q.poll();

			for (int i = 1; i <=N; i++) {
				if(map[v][i]==1&&!visited[i]) {
					q.add(i);
					visited[i]=true;
					bf.append(" "+i);
				}
			}
		}
		
	}

}
