package algorithmStudy.baekjoon.week0;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/10872
public class BJ10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(factorial(N)));

        br.close();
        bw.flush();
        bw.close();
    }

    public static int factorial(int n) {
        if(n==0||n==1) {
            return 1;
        }

        return factorial(n-1) * n;
    }
}
