package algorithmStudy.baekjoon.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/submit/1439
public class BJ1439{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int count=0;
        for (int i=1; i<str.length(); i++) {
            if (str.charAt(i-1) != str.charAt(i)) {
                count++;
            }
        }

        if (count%2 == 0) {
            System.out.println(count/2);
        } else {
            System.out.println(count/2+1);
        }
        br.close();
    }
}