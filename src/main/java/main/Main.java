package main;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to the calculator app");
        System.out.println("Please choose the operation you want to perform");
        System.out.println("1. Power");
        System.out.println("2. nCr");
        System.out.println("3: GCD");
        System.out.println("99: Exit");
        int choice = 0;
        while(choice != 99){
            choice = reader.nextInt();
            if(choice == 1) {
                System.out.println("You have chosen power function");
                System.out.println("Please enter base and exponent");
                int base = reader.nextInt();
                int exp = reader.nextInt();
                int answer = power(base, exp);
                System.out.println(base + " raise to the power " + exp + " is: ");
                System.out.println(answer);
            }
            else if(choice == 2){
                System.out.println("You have chosen nCr function");
                System.out.println("PLease enter n and r");
                int n = reader.nextInt();
                int r = reader.nextInt();
                if(n >= r){
                    int answer = nCr(n, r);
                    System.out.println("nCr for n = " + n + " and r = " + r + " is:");
                    System.out.println(answer);
                }
                else{
                    System.out.println("r cannot be greater than n");
                }
            }
            else if(choice == 3){
                System.out.println("You have chosen GCD function");
                System.out.println("Please enter the two number");
                int a = reader.nextInt();
                int b = reader.nextInt();
                System.out.println("GCD of " + a + " and " + b);
                System.out.println(gcd(a, b));
            }
            else if(choice == 4){

            }
        }
    }

    public static int power(int base, int exp){
//        System.out.println("Enter base: ");
//        int base = reader.nextInt();
//        System.out.println("Enter power");
//        int exp = reader.nextInt();
        int initialBase = base;
        int initalExp = exp;
        int answer = 1;
        while(exp > 0){
            if((exp & 1) == 1){
                answer *= base;
            }
            base *= base;
            exp >>= 1;
        }
//        System.out.println(initialBase + " raise to the power " + initalExp + " is: ");
//        System.out.println(answer);
        return answer;
    }

    public static int nCr(int n, int r){
//        if(r > n){
//            System.out.println("r cannot be greater than n");
//            return -1;
//        }
        int[][] dp = new int[n + 1][r + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
//        System.out.println("nCr for n = " + n + " and r = " + r + " is:");
//        System.out.println(dp[n][r]);
        return dp[n][r];
    }

    public static int gcd(int a, int b){
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
