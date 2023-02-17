package algorithmStudy.baekjoon.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1700
public class BJ1700{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        // stuff 별로 점수를 매겨서(몇번째 뒤에 나오는지) 우선순위 비교해서 빼도록?
        int[] multiTab = new int [N];
        int[] stuff = new int[K];
        int[] nextStuff = new int[K];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<K; i++) {
            stuff[i] = Integer.parseInt(st.nextToken());
            nextStuff[i] = 101;
        }

        // 같은 기기가 나오는 index
        for (int i=0; i<K; i++) {
            for (int j=i+1; j<K; j++) {
                if (stuff[i] == stuff[j]) {
                    nextStuff[i] = j;
                    break;
                }
            }
        }

        for(int i=0; i<N; i++) {
            multiTab[i] = -1;
        }

        int count = 0;
        for (int i=0; i<K; i++) {
            boolean exist = false;
            for (int j=0; j<N; j++) {
                if (multiTab[j] == -1 || stuff[multiTab[j]] == stuff[i]) {
                    multiTab[j] = i;
                    exist = true;
                    break;
                }
            }

            if (exist) {
                continue;
            }

            int lastStuffIndex = 0;
            for (int k=1; k<N; k++) {
                if (nextStuff[multiTab[k]] >= nextStuff[multiTab[lastStuffIndex]]) {
                    lastStuffIndex = k;
                }
            }

            multiTab[lastStuffIndex] = i;
            count++;
        }

        System.out.println(count);

        br.close();
    }
}