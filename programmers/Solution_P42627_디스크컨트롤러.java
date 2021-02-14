package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_P42627_디스크컨트롤러 {
    static int time;
    static int answer;
    public int solution(int[][] jobs) {
        answer = 0;
        time = 0;
        Queue<Job> q = new PriorityQueue<Job>();
        for (int i = 0; i < jobs.length; i++) {
            q.add(new Job(jobs[i][0], jobs[i][1]));
        }
        Job j = q.poll();
        time = j.request + j.time; // 끝난시간
        answer += j.time; // 평균
        while (!q.isEmpty()) {
        Queue<Job> work = new PriorityQueue<Job>(new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    return o1.time - o2.time;
                }
            });
        while (!q.isEmpty()&&q.peek().request <= time) {
                work.add(q.poll());
            }
            if (work.isEmpty()) {
                time = q.peek().request;
                continue;
            }

            while (!work.isEmpty()) {
                while (!q.isEmpty()&&q.peek().request <= time) {
                    work.add(q.poll());
                }
                Job w = work.poll();
                answer += time - w.request + w.time;
                time +=  w.time ;
            }

        }

        answer /= jobs.length;

        return answer;
    }

    class Job implements Comparable<Job> {
        int request;
        int time;

        public Job(int request, int time) {
            this.request = request;
            this.time = time;
        }

        @Override
        public int compareTo(Job o) {
            if(this.request == o.request){
                return this.time-o.time;
            }
            return this.request - o.request;
        }
    }

}
