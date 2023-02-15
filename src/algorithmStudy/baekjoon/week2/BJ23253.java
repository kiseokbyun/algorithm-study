package algorithmStudy.baekjoon.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ23253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i=0; i<M; i++) {
            int K = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            int min = 200001;
            for (int j=0; j<K; j++) {
                int book = Integer.parseInt(st.nextToken());
                if (min > book) {
                    min = book;
                } else {
                    System.out.println("No");
                    return;
                }
            }
        }

        System.out.println("Yes");
        br.close();
    }
}