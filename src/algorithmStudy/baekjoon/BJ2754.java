package algorithmStudy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/2754
public class BJ2754 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String grade = br.readLine();
        double result = 0;
        switch (grade.charAt(0)) {
            case 'A':
                result = 4.0;
                break;
            case 'B':
                result = 3.0;
                break;
            case 'C':
                result = 2.0;
                break;
            case 'D':
                result = 1.0;
                break;
            case 'F':
                System.out.println("0.0");
                return;
            default:
        }

        switch (grade.charAt(1)) {
            case '+':
                result+= 0.3;
                break;
            case '0':
                break;
            case '-':
                result-= 0.3;
                break;
        }

        System.out.println(result);
        br.close();
    }
}
