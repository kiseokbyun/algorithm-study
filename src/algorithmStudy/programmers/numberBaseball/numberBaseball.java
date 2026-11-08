package algorithmStudy.programmers.numberBaseball;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.function.Function;

import org.junit.Test;

public class numberBaseball {
    // public int solution(int n, Function<Integer, String> submit) {
    //     int[] numCount = new int[10];
    //     int totalCount = 0;
    //     for (int i=1; i<=9; i++){
    //         int testNum = 1000*i+100*i+10*i+i;
    //         String result = submit.apply(testNum);
    //         if (result.equals("4S 0B")) return testNum;
            
    //         int strikeCount = Integer.parseInt(result.substring(0,1));
    //         numCount[i] = strikeCount;
    //         totalCount += strikeCount;
    //         if (totalCount == 4) {
    //             break;
    //         }
    //     }

    //     if (totalCount != 4) {
    //         numCount[0] = 4-totalCount;
    //     }

    //     int[] arr = new int[4];
    //     int tmp = 0;
    //     for (int i=0; i<10; i++) {
    //         while(true) {
    //             if (numCount[i] > 0) {
    //                 arr[tmp++] = i;
    //                 numCount[i]--;
    //             } else {
    //                 break;
    //             }
    //         }
    //         if (tmp>=4) 
    //             break;
    //     }

    //     /*
    //     1234
    //     1243
    //     1324
    //     1342
    //     1423
    //     1432
    //      */
    //     int n1 = 1000*arr[0]+ 100*arr[1]+ 10*arr[2]+ arr[3];
    //     int n2 = 1000*arr[0]+ 100*arr[1]+ 10*arr[3]+ arr[2];
    //     int n3 = 1000*arr[0]+ 100*arr[2]+ 10*arr[1]+ arr[3];
    //     int n4 = 1000*arr[0]+ 100*arr[2]+ 10*arr[3]+ arr[1];
    //     int n5 = 1000*arr[0]+ 100*arr[3]+ 10*arr[1]+ arr[2];
    //     int n6 = 1000*arr[0]+ 100*arr[3]+ 10*arr[2]+ arr[1];

    //     if (submit.apply(n1).equals("4S 0B")) return n1;
    //     if (submit.apply(n2).equals("4S 0B")) return n2;
    //     if (submit.apply(n3).equals("4S 0B")) return n3;
    //     if (submit.apply(n4).equals("4S 0B")) return n4;
    //     if (submit.apply(n5).equals("4S 0B")) return n5;
    //     if (submit.apply(n6).equals("4S 0B")) return n6;


    //     /*

    //     2134
    //     2143
    //     2314
    //     2341
    //     2413
    //     2431
    //     */

    //     int n7 = 1000*arr[1]+ 100*arr[0]+ 10*arr[2]+ arr[3];
    //     int n8 = 1000*arr[1]+ 100*arr[0]+ 10*arr[3]+ arr[2];
    //     int n9 = 1000*arr[1]+ 100*arr[2]+ 10*arr[0]+ arr[3];
    //     int n10 = 1000*arr[1]+ 100*arr[2]+ 10*arr[3]+ arr[0];
    //     int n11 = 1000*arr[1]+ 100*arr[3]+ 10*arr[0]+ arr[2];
    //     int n12 = 1000*arr[1]+ 100*arr[3]+ 10*arr[2]+ arr[0];

    //     if (submit.apply(n7).equals("4S 0B")) return n7;
    //     if (submit.apply(n8).equals("4S 0B")) return n8;
    //     if (submit.apply(n9).equals("4S 0B")) return n9;
    //     if (submit.apply(n10).equals("4S 0B")) return n10;
    //     if (submit.apply(n11).equals("4S 0B")) return n11;
    //     if (submit.apply(n12).equals("4S 0B")) return n12;


    //     // 3124
    //     // 3142
    //     // 3214
    //     // 3241
    //     // 3412
    //     // 3421
    //     int n13 = 1000*arr[2]+ 100*arr[0]+ 10*arr[1]+ arr[3];
    //     int n14 = 1000*arr[2]+ 100*arr[0]+ 10*arr[3]+ arr[1];
    //     int n15 = 1000*arr[2]+ 100*arr[1]+ 10*arr[0]+ arr[3];
    //     int n16 = 1000*arr[2]+ 100*arr[1]+ 10*arr[3]+ arr[0];
    //     int n17 = 1000*arr[2]+ 100*arr[3]+ 10*arr[0]+ arr[1];
    //     int n18 = 1000*arr[2]+ 100*arr[3]+ 10*arr[1]+ arr[0];

    //     if (submit.apply(n13).equals("4S 0B")) return n13;
    //     if (submit.apply(n14).equals("4S 0B")) return n14;
    //     if (submit.apply(n15).equals("4S 0B")) return n15;
    //     if (submit.apply(n16).equals("4S 0B")) return n16;
    //     if (submit.apply(n17).equals("4S 0B")) return n17;
    //     if (submit.apply(n18).equals("4S 0B")) return n18;

    //     // 4123
    //     // 4132
    //     // 4213
    //     // 4231
    //     // 4312
    //     // 4321
        
    //     int n19 = 1000*arr[3]+ 100*arr[0]+ 10*arr[1]+ arr[2];
    //     int n20 = 1000*arr[3]+ 100*arr[0]+ 10*arr[2]+ arr[1];
    //     int n21 = 1000*arr[3]+ 100*arr[1]+ 10*arr[0]+ arr[2];
    //     int n22 = 1000*arr[3]+ 100*arr[1]+ 10*arr[2]+ arr[0];
    //     int n23 = 1000*arr[3]+ 100*arr[2]+ 10*arr[0]+ arr[1];
    //     int n24 = 1000*arr[3]+ 100*arr[2]+ 10*arr[1]+ arr[0];

    //     if (submit.apply(n19).equals("4S 0B")) return n19;
    //     if (submit.apply(n20).equals("4S 0B")) return n20;
    //     if (submit.apply(n21).equals("4S 0B")) return n21;
    //     if (submit.apply(n22).equals("4S 0B")) return n22;
    //     if (submit.apply(n23).equals("4S 0B")) return n23;
    //     if (submit.apply(n24).equals("4S 0B")) return n24;
         
    //     return 0;
    // }

    public int solution(int n, Function<Integer, String> submit) {
        
        return 0;
    }

    @Test
    public void example1() {
        check(1357, 3024);
    }

    @Test
    public void example2() {
        check(3986, 3024);
    }

    @Test
    public void example3() {
        check(7685, 33);
    }

    // 문제 설명의 단서 예시 표로 채점용 submit이 맞게 동작하는지 확인
    @Test
    public void judgeMatchesClueTable() {
        assertEquals("0S 1B", judge(1357, 7000));
        assertEquals("0S 0B", judge(1357, 2244));
        assertEquals("1S 3B", judge(1357, 3333));
        assertEquals("2S 1B", judge(1357, 3457));
        assertEquals("0S 4B", judge(1357, 7531));
        assertEquals("4S 0B", judge(1357, 1357));
    }

    // 비밀번호가 고정된 submit을 만들어 solution을 실행하고,
    // 정답과 submit 호출 횟수(n 이하)를 함께 확인
    private void check(int secret, int n) {
        int[] calls = {0};
        Function<Integer, String> submit = guess -> {
            calls[0]++;
            if (guess < 1000 || guess > 9999) {
                throw new IllegalArgumentException("1000 ~ 9999 사이가 아닌 값 제출: " + guess);
            }
            return judge(secret, guess);
        };

        int result = solution(n, submit);
        System.out.println("result = " + result + ", expected = " + secret + ", submit 호출 = " + calls[0] + " / " + n);
        assertEquals(secret, result);
        assertTrue("submit 호출 횟수 초과: " + calls[0] + " > " + n, calls[0] <= n);
    }

    // 제출한 수의 각 자릿수마다: 같은 자리에 있으면 STRIKE, 다른 자리에 있으면 BALL
    private static String judge(int secret, int guess) {
        String s = String.valueOf(secret);
        String g = String.valueOf(guess);
        int strike = 0, ball = 0;
        for (int i = 0; i < 4; i++) {
            char c = g.charAt(i);
            if (s.charAt(i) == c) strike++;
            else if (s.indexOf(c) >= 0) ball++;
        }
        return strike + "S " + ball + "B";
    }
}
