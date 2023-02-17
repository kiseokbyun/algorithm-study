package algorithmStudy.baekjoon.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1135
public class BJ1135{
    private static class Point {
        int time;
        ArrayList<Point> child = new ArrayList<>();

        public Point(int time) {
            this.time = time;
        }

        public void addChild(Point point) {
            child.add(point);
        }

        public void setTime() {
            this.time = child.size();

            if (!child.isEmpty()) {
                child.sort((c1, c2) -> Integer.compare(c2.time, c1.time));
            }

            for (int i=0; i<child.size(); i++) {
                this.time = Math.max(this.time, child.get(i).time + i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int [N];
        Point[] point = new Point[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            point[i] = new Point(0);
        }

        for (int i=N-1; i>0; i--) {
            point[i].setTime();
            point[arr[i]].addChild(point[i]);
        }
        point[0].setTime();

        System.out.println(point[0].time);

        br.close();
    }
}