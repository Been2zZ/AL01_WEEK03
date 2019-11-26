package FibonacciNumberSequence;


import java.math.BigInteger;

public class RecursiveSquaring {

    BigInteger zero = BigInteger.ZERO;
    BigInteger one = BigInteger.ONE;

    public BigInteger Fibonacci(int n) {
        BigInteger[][] A = {{one, one}, {one, zero}};       /* 1  1
                                                               1  0 */

        if(n == 0) return zero;
        else if(n == 1) return one;

        A = POW(A, n);      // 행렬 A의 n제곱을 계산

        return A[0][1];     // Fn = A(0, 1)
    }

    public BigInteger[][] POW(BigInteger[][] A, int n) {
        BigInteger[][] F1 = {{one, one}, {one, zero}};

        // if(n == 1)  return A;

        if(n > 1) {
            /* 지수의 홀짝에 따라 각각 디른 값을 return */
            if(n % 2 == 0) {
                // even
                A = POW(A, n/2);
                A = MUL(A, A);
            }
            else {
                // odd
                A = POW(A, (n - 1)/2);
                A = MUL(A, A);
                A = MUL(A, F1);     // 홀수 : 피보나치 행렬(1제곱)과 MUL 연산 한번 더 해준다.
            }
        }
        return A;
    }

    public BigInteger[][] MUL(BigInteger[][] A, BigInteger[][] B) {
        /* 행렬 A와 B를 곱한 결과 return */

        int n = A.length;

        BigInteger[][] C = new BigInteger[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                C[i][j] = zero;
                for(int k = 0; k < n; k++) {
                    BigInteger ab = A[i][k].multiply(B[k][j]);  // A[i][k] * B[k][j]
                    C[i][j] = ab.add(C[i][j]);      // A[i][k] * B[k][j] + C[i][j]
                }
            }
        }
        return C;
    }

    public void RecursiveSquaringFibonacciTest(int k) {
        double totalStartTime = System.currentTimeMillis();
        for(int i = 0; i <= k; i++) {
            if(i % 10 == 0) System.out.println("------------------------------------------------------------------");
            double startTime = System.nanoTime();
            //System.out.print("f<"+ i + "> = " + Fibonacci(i));
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