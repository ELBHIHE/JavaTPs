package tps.tp2.nombres;

import tps.utils.ConsoleFontFormat;

import java.util.Scanner;

public class ServiceComplexes {

    public static   Complex add         (Complex c1, Complex c2){

        var re = c1.getRe() + c2.getRe();
        var im = c1.getIm() + c2.getIm();

        return new Complex(re, im);
    }
    public static   Complex mines       (Complex c1, Complex c2){

        var re = c1.getRe() - c2.getRe();
        var im = c1.getIm() - c2.getIm();

        return new Complex(re, im);
    }
    public static   Complex multiply    (Complex c1, Complex c2){

        var re = c1.getRe() * c2.getRe() - c1.getIm() * c2.getIm();
        var im = c1.getIm()*c2.getRe() + c2.getIm()*c1.getRe();

        return new Complex(re, im);
    }
    public static   Complex divides     (Complex c1, Complex c2){
        return multiply(c1, reciprocal(c2));
    }
    public static   Complex reciprocal  (Complex c1){

        var re = c1.getRe()/Math.pow(module(c1), 2);
        var im = -c1.getIm()/Math.pow(module(c1), 2);

        return new Complex(re, im);
    }
    private static  double  module      (Complex c1) {
        var m =  Math.hypot(c1.getRe(), c1.getIm());
        m = (double)Math.round(m*100)/100;

        return m;
    }
    public static   Complex conjugate   (Complex c1){

        var re = c1.getRe();
        var im = -c1.getIm();

        return new Complex(re, im);
    }

    // ===============================================================================================================
    public  static      Complex     createComplex(Scanner keyboard, String name){
        System.out.println("Creation of a Complex " +name);
        System.out.print("Enter the value of the real part : ");
        var re = keyboard.nextDouble();
        System.out.print("Enter the value of the imaginary part : ");
        var im = keyboard.nextDouble();

        return new Complex(re, im);
    }
    private static      Complex     createComplexeOrGetExisting(Scanner keyboardReader, String complexName, Complex c) {
        if (c == null) {
            System.out.println(c + " not found!!! Let's create one first.");
            return createComplex(keyboardReader, complexName);
        }
        return c;
    }
    public  static      void        menuApplication (Scanner keyboardReader){

        Complex c1 = null, c2 = null;

        while (true) {
            System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_BLUE);
            System.out.print("""
                ===================================================
                =                 Complex Operations              =
                ===================================================
                = 1. Operations on a single Complexe              =
                = 2. Operations on two Complexes                  =
                = 3. Exit                                         =
                ===================================================
                """);
            System.out.print(ConsoleFontFormat.FontFormat_RESET);
            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
            System.out.print("=> Enter your choice : ");
            int choice = keyboardReader.nextInt();
            keyboardReader.nextLine();  // Clear the buffer

            switch (choice) {
                case 1 -> {
                    // Single array operations
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_PURPLE);
                    c1 = createComplexeOrGetExisting(keyboardReader, "C1", c1);
                    System.out.print(ConsoleFontFormat.FontFormat_ITALIC+ConsoleFontFormat.FontFormat_BLUE);
                    System.out.println("\t\t\t\t Complexe C1 : " +c1);
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_BLUE);
                    System.out.print("""
                                                \t\t===================================================
                                                \t\t=       Choose an operation for one Complex       =
                                                \t\t===================================================
                                                \t\t= 1. Print Complexe                               =
                                                \t\t= 2. Module of the Complexe                       =
                                                \t\t= 3. Conjugate of the Complexe                    =
                                                \t\t= 4. Reciprocal of the Complexe                   =
                                                \t\t= 5. Back to Main Menu                            =
                                                \t\t===================================================
                                                """);
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
                    System.out.print("\t\t=> Enter your choice : ");
                    int singleArrayChoice = keyboardReader.nextInt();
                    keyboardReader.nextLine();  // Clear buffer

                    switch (singleArrayChoice) {
                        case 1 -> {
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                            System.out.println("\t\t\t\tComplex c1 : " + c1);
                            System.out.print(ConsoleFontFormat.FontFormat_RESET);
                        }
                        case 2 -> {
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                            System.out.println("\t\t\t\tComplex c1 : " + c1);
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_BLUE);
                            System.out.println("\t\t\t\t |c1| : " + module(c1));
                            System.out.println(ConsoleFontFormat.FontFormat_RESET);
                        }
                        case 3 ->   {
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                            System.out.println("\t\t\t\tComplex c1 : " + c1);
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_ITALIC +ConsoleFontFormat.FontFormat_BLUE);
                            System.out.println("\t\t\t\tConjugate of c1 : " + conjugate(c1));
                            System.out.print(ConsoleFontFormat.FontFormat_RESET);
                        }
                        case 4 -> {
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                            System.out.println("\t\t\t\tComplex c1 : " + c1);
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_ITALIC +ConsoleFontFormat.FontFormat_BLUE);
                            System.out.println("\t\t\t\tReciprocal of c1 : " + reciprocal(c1));
                            System.out.print(ConsoleFontFormat.FontFormat_RESET);
                        }
                        case 5 -> {
                            // Go back to main menu
                        }
                        default -> {
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_RED);
                            System.out.println("\t\t\t\tInvalid choice! Please try again.");
                            System.out.print(ConsoleFontFormat.FontFormat_RESET);
                        }
                    }
                }

                case 2 -> {

                    System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                    // Two array operations
                    c1 = createComplexeOrGetExisting(keyboardReader, "C1",  c1);
                    c2 = createComplexeOrGetExisting(keyboardReader, "C2",  c2);

                    System.out.println("\t\t\t\t Complexe C1 : " +c1);
                    System.out.println("\t\t\t\t Complexe C2 : " +c2);

                    System.out.print("""
                                                \t\t===================================================
                                                \t\t=          Choose an operation for two arrays      =
                                                \t\t===================================================
                                                \t\t= 1. Sum                                           =
                                                \t\t= 2. Soustraction                                  =
                                                \t\t= 3. Multiplication                                =
                                                \t\t= 4. Division                                      =
                                                \t\t= 5. Back to Main Menu                             =
                                                \t\t===================================================
                                                """);
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
                    System.out.print("\t\t=> Enter your choice : ");
                    int twoArrayChoice = keyboardReader.nextInt();
                    keyboardReader.nextLine();  // Clear buffer

                    switch (twoArrayChoice) {
                        case 1 -> {
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                            System.out.println("\t\t\t\t Complexe C1 : " +c1);
                            System.out.println("\t\t\t\t Complexe C2 : " +c2);
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_BLUE);
                            System.out.println("\t\t\t\t Complexe C1 + C2 : " +add(c1, c2));
                            System.out.print(ConsoleFontFormat.FontFormat_RESET);
                        }
                        case 2 -> {
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                            System.out.println("\t\t\t\t Complexe C1 : " +c1);
                            System.out.println("\t\t\t\t Complexe C2 : " +c2);
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_BLUE);
                            System.out.println("\t\t\t\t Complexe C1 - C2 : " +mines(c1, c2));
                            System.out.print(ConsoleFontFormat.FontFormat_RESET);
                        }
                        case 3 -> {
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                            System.out.println("\t\t\t\t Complexe C1 : " +c1);
                            System.out.println("\t\t\t\t Complexe C2 : " +c2);
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_BLUE);
                            System.out.println("\t\t\t\t Complexe C1 * C2 : " +multiply(c1, c2));
                            System.out.print(ConsoleFontFormat.FontFormat_RESET);
                        }
                        case 4 -> {
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
                            System.out.println("\t\t\t\t Complexe C1 : " +c1);
                            System.out.println("\t\t\t\t Complexe C2 : " +c2);
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_BLUE);
                            System.out.println("\t\t\t\t Complexe C1 / C2 : " +divides(c1, c2));
                            System.out.print(ConsoleFontFormat.FontFormat_RESET);
                        }
                        case 5 -> {
                            // Go back to main menu
                        }
                        default -> {
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_RED);
                            System.out.println("\t\t\t\tInvalid choice! Please try again.");
                            System.out.print(ConsoleFontFormat.FontFormat_RESET);
                        }
                    }
                }

                case 3 -> {
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
