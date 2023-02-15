package algorithmStudy.baekjoon.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//https://www.acmicpc.net/problem/1662
public class BJ1662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        Stack<Integer> len = new Stack<>();
        Stack<Integer> mul = new Stack<>();


        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            char tmp = line.charAt(i);

            if (tmp == ')') {
                count *=mul.pop();
                count +=len.pop();
            } else if (tmp == '(') {
                len.push(--count);
                mul.push(line.charAt(i-1)-'0');
                count = 0;
            } else {
                count++;
            }
        }
        System.out.println(count);

        br.close();
    }
}
