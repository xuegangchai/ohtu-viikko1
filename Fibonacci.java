/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chai
 */
import java.util.Scanner;

public class Fibonacci {

    public static int fibonacci(int n) {
            int fib1 = 1;
            int fib2 = 0;
            int fib3 = 0;
            for (int i = 0; i < n; i++) {
                fib3 = fib1 + fib2;
                fib1 = fib2;
                fib2 = fib3;
            }
            return fib2;
        
    }
    public static Scanner lukija = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("n: ");
        int n = lukija.nextInt();
        System.out.println("F(n): " + fibonacci(n));
    }
}
