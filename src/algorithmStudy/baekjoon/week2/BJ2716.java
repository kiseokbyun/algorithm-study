package algorithmStudy.baekjoon.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/2716
public class BJ2716{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String line = br.readLine();

            int max=0, count = 0;
            for (int i=0; i<line.length(); i++) {
                if (line.charAt(i) == '[') {
                    count++;
                } else {
                    count--;
                }

                max = Math.max(max, count);
            }

            System.out.println((int)(Math.pow(2,max)));
        }
        br.close();
    }
}