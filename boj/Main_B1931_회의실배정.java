package boj;

import java.io.*;
import java.util.*;

public class Main_B1931_회의실배정 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int ans = 0;
		int endTime = -1;
		PriorityQueue<Time> pq = new PriorityQueue<Time>();
		Time time;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			time = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			pq.add(time);
		}
		while (!pq.isEmpty()) {
			time = pq.poll();
			if (endTime <= time.s) {
				ans++;
				endTime = time.e;
			}
		}
		System.out.println(ans);
	}

}

class Time implements Comparable<Time> {
	int s;
	int e;

	public Time(int s, int e) {
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(Time t) {
		if (this.e == t.e) {
			return this.s > t.s ? 1 : -1;
		}
		return this.e > t.e ? 1 : -1;
	}
}
