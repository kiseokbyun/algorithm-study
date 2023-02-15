package algorithmStudy.baekjoon.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ16120 {
    private static final String PPAP = "PPAP";
    private static final String NP = "NP";
    private static final char P = 'P';
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        Stack<Character> stack = new Stack<>();

        try {
            for (int i=0; i<line.length();i++) {
                char tmp = line.charAt(i);
                if (tmp == 'A') {
                    char p1 = stack.pop();
                    char p2 = stack.pop();

                    char p3 = line.charAt(++i);

                    if (p1 == P && p2 == P && p3 == P) {
                        stack.push('P');
                    } else {
                        System.out.println(NP);
                        return;
                    }
                } else {
                    stack.push(line.charAt(i));
                }
            }
        } catch (Exception e) {
            System.out.println(NP);
            return;
        }


        if (stack.size() == 1) {
            System.out.println(PPAP);
        } else {
            System.out.println(NP);
        }

        br.close();
    }
}
