package tps.tp1;

import tps.tp1.arrays.ArraysOperation;
import tps.tp1.factorials.Functions;
import tps.tp1.dates.Dates;
import tps.utils.ConsoleFontFormat;

import java.util.Scanner;

public class TestTp1 {

    public static void testOfDates() {
        System.out.println(ConsoleFontFormat.FontFormat_BOLD);
        System.out.println("================================================================================================");
        System.out.print(ConsoleFontFormat.FontFormat_RESET);
        Dates.test1();
        Dates.test2();
        Dates.test3();
        Dates.test4();
        Dates.test5();
    }
    public static void testOfArraysOperations(Scanner keyboard) {
        ArraysOperation.menuApplication(keyboard);
    }
    public static void testOfFactorialFunctions(Scanner keyboard) {
        Functions.menuFactorial(keyboard);
    }
    public static void main(String[] args) {

        var keyboardReader = new Scanner(System.in);

        System.out.println("Welcome To your first Java Program ^_^");
        System.out.println("You are free to choose to test one of the 3 exercices");

        while (true) {
            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_BLUE);
            System.out.print("""
                ===================================================
                =               TP1 : First Java App              =
                ===================================================
                = 1. exercice 1 : Array's functions               =
                = 2. exercice 2 : Factorial's functions           =
                = 3. exercice 3 : Test Dates Objets & functions   =
                = 4. Exit                                         =
                ===================================================
                """);
            System.out.print(ConsoleFontFormat.FontFormat_RESET);
            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
            System.out.print("=> Enter your choice : ");
            int choice = keyboardReader.nextInt();
            keyboardReader.nextLine();  // Clear the buffer

            switch (choice) {
                case 1 ->   { testOfArraysOperations(keyboardReader);}

                case 2 ->   { testOfFactorialFunctions(keyboardReader);}

                case 3 ->   { testOfDates();}

                case 4 ->   {
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_RED);
                    System.out.println("Exiting the application...");
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    return;
                }

                default -> {
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_RED);
                    System.out.println("Invalid choice! Please try again.");
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                }
            }
        }


    }
}
