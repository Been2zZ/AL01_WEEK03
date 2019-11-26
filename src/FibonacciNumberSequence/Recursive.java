package FibonacciNumberSequence;

import java.math.BigInteger;

public class Recursive {

    BigInteger zero = BigInteger.ZERO;
    BigInteger one = BigInteger.ONE;

    private BigInteger Fibonacci(int n) {
        if(n == 0)  return zero;    // 0
        else if(n == 1) return one; // 1
        else {
            return Fibonacci(n - 1).add(Fibonacci(n - 2));  // F(n - 1) + F(n - 2)
        }
    }

    public void RecursiveFibonacciTest(int k) {
        double totalStartTime = System.currentTimeMillis();
        for(int i = 0; i <= k; i++) {
            if(i % 10 == 0) System.out.println("------------------------------------------------------------------");
            double startTime = System.nanoTime();
            System.out.print(String.format("f<%d> = %-25d", i, Fibonacci(i)));
            double endTime = System.nanoTime();
            double secTime = (endTime - startTime)/1000000000;
            System.out.format("\t\t\t\t%.12f sec\n", secTime);
        }
        double totalEndTime = System.currentTimeMillis();
        double totalSecTime = (totalEndTime - totalStartTime)/1000;

        System.out.println("\ntotal excute time : " + totalSecTime + "sec");
    }
}
