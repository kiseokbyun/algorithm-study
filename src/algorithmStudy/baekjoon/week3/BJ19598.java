package algorithmStudy.baekjoon.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//https://www.acmicpc.net/problem/19598
public class BJ19598 {
    public static class Meeting {
        public int start;
        public int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        List<Meeting> input = new ArrayList<>();
        while (N-- > 0) {
            String[] times = br.readLine().split(" ");
            int start = Integer.parseInt(times[0]), end = Integer.parseInt(times[1]);
            input.add(new Meeting(start, end));
        }
        input.sort((c1, c2) -> {
            if (c1.start < c2.start) {
                return -1;
            } else if (c1.start == c2.start) {
                return Integer.compare(c1.end, c2.end);
            } else {
                return 1;
            }
        });

        int max = 0;
        for (Meeting cls : input) {
            while (queue.size() > 0) {
                if (cls.start < queue.peek()) {
                    break;
                } else {
                    queue.poll();
                }
            }
            queue.add(cls.end);
            max = Math.max(max, queue.size());
        }

        System.out.println(max);

        br.close();
    }
}
