package algorithmStudy.baekjoon.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//https://www.acmicpc.net/problem/1379
public class BJ1379{
    public static class Class {
        public int id;
        public int start;
        public int end;

        public Class(int room, int start, int end) {
            this.id = room;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Class> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));

        List<Class> input = new ArrayList<>();
        int[] classRooms = new int[N+1];    // 강의 별 강의실 번호
        boolean[] emptyRooms = new boolean[N+1];  // 최대 필요 강의실 N
        for (int i=0; i<N; i++) {
            String[] times = br.readLine().split(" ");
            int room = Integer.parseInt(times[0]);

            int start = Integer.parseInt(times[1]), end = Integer.parseInt(times[2]);
            input.add(new Class(room, start, end));
            emptyRooms[i] = true;
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
        for (Class cls : input) {
            while (queue.size() > 0) {
                if (cls.start < queue.peek().end) {
                    break;
                } else {
                    Class tmp = queue.poll();
                    emptyRooms[classRooms[tmp.id]] = true;
                }
            }
            for (int i=1; i<N; i++) {
                if (emptyRooms[i]) {
                    classRooms[cls.id] = i;
                    emptyRooms[i] = false;
                    break;
                }
            }

            queue.add(cls);
            max = Math.max(max, queue.size());
        }

        System.out.println(max);
        for (int i=1;i<N+1; i++) {
            System.out.println(classRooms[i]);
        }
        br.close();
    }
}