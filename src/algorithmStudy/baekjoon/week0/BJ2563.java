package algorithmStudy.baekjoon.week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // false로 초기화
        boolean[][] points = new boolean[100][100];

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());

            for (int i=A; i<A+10; i++) {
                for (int j = B; j<B+10; j++) {
                    points[i][j] = true;
                }
            }
        }

        int sum = 0;
        for (int i=0; i<100; i++) {
            for (int j=0; j<100; j++) {
                if (points[i][j]) {
                    sum++;
                }
            }
        }

        System.out.println(sum);
        br.close();
    }
}
