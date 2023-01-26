package algorithmStudy.baekjoon.week0;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1543
public class BJ1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String doc = br.readLine();
        String word = br.readLine();
        int i =0,j = 0,result=0;

        while (i+j < doc.length()) {
            if (doc.charAt(i + j) == word.charAt(j)) {
                j++;
            } else {
                i++;
                j = 0;
                continue;
            }

            if (j == word.length()) {
                result++;
                i += j;
                j = 0;
            }
        }

        System.out.println(result);

        br.close();
    }
}
