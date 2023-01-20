package algorithmStudy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//https://www.acmicpc.net/problem/9506
public class BJ9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N==-1) {
                break;
            }

            List<Integer> divisorList = new ArrayList<>();
            divisorList.add(1);

            double sqrt = Math.sqrt(N);
            for (int i=2; i<sqrt; i++) {
                if (N % i == 0) {
                    divisorList.add(i);
                    divisorList.add(N/i);
                }
            }

            System.out.print(N);

            if (N == divisorList.stream().mapToInt(d -> d).sum()) {
                int[] sortedDivisors = divisorList.stream().mapToInt(d -> d).sorted().toArray();
                System.out.print(" = ");
                for (int i=0; i<sortedDivisors.length-1; i++)  {
                    System.out.print(sortedDivisors[i] + " + ");
                }
                System.out.println(sortedDivisors[sortedDivisors.length-1]);
            } else {
                System.out.println(" is NOT perfect.");
            }
        }

        br.close();
    }
}
