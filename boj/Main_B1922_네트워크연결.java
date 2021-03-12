package boj;

import java.util.*;
import java.io.*;

public class Main_B1922_네트워크연결 {

	static int N;
	static int M;
	static int parent[];
	static int cnt ; 
	static int answer ; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		cnt = N;
		PriorityQueue<Net> pq = new PriorityQueue<Net>();
		Net n;
		StringTokenizer st;
		int a,b,c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
		    c = Integer.parseInt(st.nextToken());
			n = new Net(a, b, c);
			pq.add(n);
		}
		
		while(!pq.isEmpty()) {
			if(cnt == 1) break;
			n = pq.poll();
			a = find(n.a);
			b = find(n.b);
			if(a!=b) {
				answer+= n.cost;
				union(a,b);
				cnt--;
			}
		}
		System.out.println(answer);
		
	}
	private static void union(int a, int b) {
		parent[a] =b ; 
	}
	public static int find(int a) {
		if(parent[a]==a) {
			return a ;
		}
		
		return parent[a] = find(parent[a]);
	}
	
	

}

class Net implements Comparable<Net> {
	int a;
	int b;
	int cost;

	public Net(int a, int b, int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}

	@Override
	public int compareTo(Net o) {
		return this.cost - o.cost;
	}

}
