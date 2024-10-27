package tps.tp1.factorials;

import tps.utils.ConsoleFontFormat;

import java.math.BigInteger;
import java.util.Scanner;


public class Functions {

    public static int factorialIterative(int n) {
        int f = 1;
        if(n==0) return 1;

                for(int i = 2; i<= n; i++)  f = f * i;
        return f;
    }
    public static int factorialRecursive(int n) {
            if(n==0) return 1;
            else     return n * factorialRecursive(n-1);
    }
    public static BigInteger factorialIterative_Optimised(int n) {
        BigInteger f = BigInteger.ONE;

        if(n==0) return BigInteger.ONE;
        for(int i = 2; i<= n; i++)
            f = f.multiply(BigInteger.valueOf(i));

        return f;
    }
    public static BigInteger factorialRecursive_Optimised(int n) {
        if(n==0)    return BigInteger.ONE;
        else        return
                        factorialRecursive_Optimised(n-1)
                                .multiply(
                                            BigInteger.valueOf(n));
    }

    public static void menuFactorial(Scanner keyboardReader) {
        while (true) {
            System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_BLUE);
            System.out.print("""
            ===================================================
            =               Factorial Operations              =
            ===================================================
            = 1. Iterative Factorial                          =
            = 2. Recursive Factorial                          =
            = 3. Optimised Iterative Factorial                =
            = 4. Optimised Recursive Factorial                =
            = 5. exit                                         =
            ===================================================
            """);
            System.out.print(ConsoleFontFormat.FontFormat_RESET);
            System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_GREEN);
            System.out.print("=> Enter your choice : ");
            int choice = keyboardReader.nextInt();
            keyboardReader.nextLine();  // Clear the buffer

            switch (choice) {
                case 1 -> {
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_GREEN);
                    System.out.print("=> Enter a positive number : ");
                    int number = keyboardReader.nextInt();
                    keyboardReader.nextLine();  // Clear the buffer
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    if(number > 12) {
                        System.out.println(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_RED);
                        System.out.println(number +"! will be a big number!!! use an optimised function ^_^");
                        System.out.println(ConsoleFontFormat.FontFormat_RESET);
                    }
                    else {
                        int result = factorialIterative(number);
                        System.out.println(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_PURPLE);
                        System.out.println("\t\"Classic Iterative Factorial\"");
                        System.out.println("\t" + number + "! = " + ConsoleFontFormat.FontFormat_GREEN + result);
                        System.out.println(ConsoleFontFormat.FontFormat_RESET);
                    }
                }
                case 2 -> {
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_GREEN);
                    System.out.print("=> Enter a positive number : ");
                    int number = keyboardReader.nextInt();
                    keyboardReader.nextLine();  // Clear the buffer
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    if(number > 12) {
                        System.out.println(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_RED);
                        System.out.println(number +"! will be a big number!!! use an optimised function ^_^");
                        System.out.println(ConsoleFontFormat.FontFormat_RESET);
                    }
                    else {
                    int result = factorialRecursive(number);
                    System.out.println(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_PURPLE);
                    System.out.println("\t\"Classic Recursive Factorial\"");
                    System.out.println("\t" + number + "! = " + ConsoleFontFormat.FontFormat_GREEN + result);
                    System.out.println(ConsoleFontFormat.FontFormat_RESET);
                    }
                }
                case 3 -> {
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_GREEN);
                    System.out.print("=> Enter a positive number : ");
                    int number = keyboardReader.nextInt();
                    keyboardReader.nextLine();  // Clear the buffer
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    BigInteger result = factorialIterative_Optimised(number);
                    System.out.println(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_PURPLE);
                    System.out.println("\t\"Optimised Iterative Factorial\"");
                    System.out.println("\t" + number + "! = " + ConsoleFontFormat.FontFormat_GREEN + result);
                    System.out.println(ConsoleFontFormat.FontFormat_RESET);
                }
                case 4 -> {
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_GREEN);
                    System.out.print("=> Enter a positive number : ");
                    int number = keyboardReader.nextInt();
                    keyboardReader.nextLine();  // Clear the buffer
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    BigInteger result = factorialRecursive_Optimised(number);
                    System.out.println(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_PURPLE);
                    System.out.println("\t\"Optimised Recursive Factorial\"");
                    System.out.println("\t" + number + "! = " + ConsoleFontFormat.FontFormat_GREEN + result);
                    System.out.println(ConsoleFontFormat.FontFormat_RESET);
                }
                case 5 -> {

                    System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_RED);
                    System.out.println("Exiting the application...");
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    System.exit(0);
                }

                default -> {
                    System.out.println(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_RED);
                    System.out.println("Invalid choice! Please try again.");
                    System.out.println(ConsoleFontFormat.FontFormat_RESET);
                }
            }
        }
    }

}
