package algorithmStudy.baekjoon.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

//https://www.acmicpc.net/problem/1417
public class BJ1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if (N==1) {
            System.out.println(0);
            return;
        }
        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=1; i<N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while (true) {
            Integer rival = queue.poll();
            if (rival ==null || rival < dasom) {
                break;
            }

            dasom++; count++;
            queue.add(--rival);
        }

        System.out.println(count);
        br.close();
    }
}