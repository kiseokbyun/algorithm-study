package algorithmStudy.baekjoon.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1182
public class BJ1182 {
    private static int S;
    private static int[] array;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        array = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0);

        System.out.println(count);

        br.close();
    }

    private static void solution (int i, int sum) {
        if (i>= array.length) {
            return;
        }

        sum += array[i];
        solution(i+1, sum);

        if (sum == S) {
            count++;
        }

        sum -= array[i];
        solution(i+1, sum);
    }
}
