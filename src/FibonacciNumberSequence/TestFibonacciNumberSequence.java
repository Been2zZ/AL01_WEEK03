package FibonacciNumberSequence;

import java.util.Scanner;

public class TestFibonacciNumberSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Recursive r = new Recursive();
        BottomUp b = new BottomUp();
        RecursiveSquaring rs = new RecursiveSquaring();

        System.out.println("< 1 : Recursion >");
        System.out.println("< 2 : Array >");
        System.out.println("< 3 : Recursive squaring >");

        System.out.print("\n몇번째 피보나치 수를 구하시겠습니까 : ");
        int k = sc.nextInt();

        System.out.print("\n알고리즘을 선택하세요 : ");
        int n = sc.nextInt();

        if(n == 1)
            r.RecursiveFibonacciTest(k);
        else if (n == 2)
            b.BottomUpFibonacciTest(k);
        else if (n == 3)
            rs.RecursiveSquaringFibonacciTest(k);
        else System.out.println("잘못된 선택입니다.");

    }
}
