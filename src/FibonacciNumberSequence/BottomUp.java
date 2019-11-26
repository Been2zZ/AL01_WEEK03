package FibonacciNumberSequence;

import java.math.BigInteger;

public class BottomUp {

    BigInteger zero = BigInteger.ZERO;
    BigInteger one = BigInteger.ONE;

    BigInteger temp[] = new BigInteger[1000];       // 저장 배열

    private BigInteger Fibonacci(int k) {

        temp[0] = zero; // 0
        temp[1] = one;  // 1

        for(int i = 2; i <= k; i++)
            temp[i] = temp[i - 1].add(temp[i - 2]); // temp[i] = temp[i - 1] + temp[i - 2]

        return temp[k];         // k번째 피보나치 수
    }

    public void BottomUpFibonacciTest(int k) {
        double totalStartTime = System.currentTimeMillis();
        for(int i = 0; i <= k; i++) {
            if(i % 10 == 0) System.out.println("------------------------------------------------------------------");
            double startTime = System.nanoTime();
            Fibonacci(k);
            double endTime = System.nanoTime();
            System.out.print(String.format("f<%d> = %-25d", i, Fibonacci(i)));
            double secTime = (endTime - startTime)/1000000000;
            System.out.format("\t\t\t\t%.12f sec\n", secTime);
        }
        double totalEndTime = System.currentTimeMillis();
        double totalSecTime = (totalEndTime - totalStartTime)/1000;

        System.out.println("\ntotal excute time : " + totalSecTime + "sec");
    }
}
