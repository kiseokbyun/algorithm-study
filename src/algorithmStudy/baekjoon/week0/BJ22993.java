package algorithmStudy.baekjoon.week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/22993
public class BJ22993 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long junOne = Integer.parseInt(st.nextToken());

        int[] A = new int[N-1];
        for (int i=1; i<N; i++) {
            A[i-1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for (long num : A) {
            if (junOne > A[N-2]) {
                System.out.println("Yes");
                return;
            }

            if (num < junOne) {
                junOne += num;
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
        br.close();
    }
}
