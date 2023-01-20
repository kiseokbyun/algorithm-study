package algorithmStudy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/26645
public class BJ26645 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if (N < 206) {
            System.out.println(1);
        } else if (N < 218) {
            System.out.println(2);
        } else if (N < 229) {
            System.out.println(3);
        } else {
            System.out.println(4);
        }

        br.close();
    }
}

