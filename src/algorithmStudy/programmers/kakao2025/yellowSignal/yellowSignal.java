package algorithmStudy.programmers.kakao2025.yellowSignal;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class yellowSignal {
    public int solution(int[][] signals) {
        int answer = -1;
        int lcm = 1;

        boolean[][] signalBits = new boolean[signals.length][];

        // yellow만 true
        for (int i=0; i<signals.length; i++) {
            int green = signals[i][0];
            int yellow = signals[i][1];
            int red = signals[i][2];

            int total = green+yellow+red;

            signalBits[i] = new boolean[total];
            for (int j=0; j<green; j++) {
                signalBits[i][j] = false;
            }
            for (int j=0; j<yellow; j++) {
                signalBits[i][green+j] = true;
            }
            for (int j=0; j<red; j++) {
                signalBits[i][green+yellow+j] = false;
            }
        }

        // lcm 계산
        for (int[] signal : signals) {
            lcm = lcm(lcm, Arrays.stream(signal).sum());
        }
        System.out.println(lcm);

        // lcm 까지 모두 노랑인것 있는지확인
        for (int i=0; i<lcm; i++) {
            boolean flag=true;
            for (boolean[] signalBit : signalBits) {
                flag &= signalBit[i%signalBit.length];
            }
            if (flag) {
                return i+1;
            }
        }

        return answer;
    }

    // 최대공약수(GCD) 구하기 - 유클리드 호제법
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 최소공배수(LCM) 구하기
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    @Test
    public void example1() {
        int[][] signals = {{2, 1, 2}, {5, 1, 1}};
        check(13, solution(signals));
    }

    @Test
    public void example2() {
        int[][] signals = {{2, 3, 2}, {3, 1, 3}, {2, 1, 1}};
        check(11, solution(signals));
    }

    @Test
    public void example3() {
        int[][] signals = {{3, 3, 3}, {5, 4, 2}, {2, 1, 2}};
        check(193, solution(signals));
    }

    @Test
    public void example4() {
        int[][] signals = {{1, 1, 4}, {2, 1, 3}, {3, 1, 2}, {4, 1, 1}};
        check(-1, solution(signals));
    }

    private void check(int expected, int result) {
        System.out.println("result = " + result + ", expected = " + expected);
        assertEquals(expected, result);
    }
}
