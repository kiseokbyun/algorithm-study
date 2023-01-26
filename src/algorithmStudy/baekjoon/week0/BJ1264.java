package algorithmStudy.baekjoon.week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1264
public class BJ1264 {
    public static void main(String[] args) throws IOException {
        char[] vowels = {'a','e','i','o','u'};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine().toLowerCase();
            if (line.equals("#")) {
                break;
            }

            int totalCount=0;
            for (char vowel : vowels) {
                totalCount += count(line, vowel);
            }

            System.out.println(totalCount);
        }


        br.close();
    }

    public static int count(String str, char ch) {
        return (int) str.chars()
                .filter(c -> c == ch)
                .count();
    }
}
