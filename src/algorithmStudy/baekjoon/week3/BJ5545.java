package algorithmStudy.baekjoon.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/5545
public class BJ5545{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        double[] price = new double[2];
        price[0] = Double.parseDouble(st.nextToken());    // 도우
        price[1] = Double.parseDouble(st.nextToken());    // 토핑

        int dough = Integer.parseInt(br.readLine());
        Double[] toping = new Double[N];
        for (int i=0; i<N; i++) {
            toping[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(toping, Collections.reverseOrder());

        double totalEnergy = dough;
        double totalPrice = price[0];
        for (int i=0; i<N; i++) {
            double avgEnergy = totalEnergy / totalPrice;
            if (avgEnergy < toping[i] / price[1]) {
                totalEnergy += toping[i];
                totalPrice += price[1];
            }
        }
        System.out.println((int)(totalEnergy/totalPrice));

        br.close();
    }
}