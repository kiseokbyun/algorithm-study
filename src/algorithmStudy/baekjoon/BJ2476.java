package algorithmStudy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/2476
public class BJ2476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int max = 0;
        for (int i=0; i<N; i++) {
            int[] dice = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (dice[0] == dice[1] && dice[0] == dice[2]) {
                max = Math.max(max, 10000 + dice[0] * 1000);
            } else if (dice[0] == dice[1] || dice[0] == dice[2]) {
                max = Math.max(max, 1000 + dice[0] * 100);
            } else if (dice[1] == dice[2]) {
                max = Math.max(max, 1000 + dice[1] * 100);
            } else {
                max = Math.max(max, dice[0] * 100);
                max = Math.max(max, dice[1] * 100);
                max = Math.max(max, dice[2] * 100);
            }
        }

        System.out.println(max);
        br.close();
    }
}