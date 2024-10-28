package tps.tp2.equations;

import tps.tp2.nombres.Complex;
import tps.tp2.nombres.ServiceComplexes;
import tps.utils.ConsoleFontFormat;

import java.util.Scanner;

public class ServiceEquations {

    public static Equation2Dg createEquation(Scanner clavier){
        System.out.println("Création d'équation : aX^2 + bX + c = 0");
        System.out.println("Entrez la valeur de a : ");
        double  a = clavier.nextDouble();
        System.out.println("Entrez la valeur de b : ");
        double  b = clavier.nextDouble();
        System.out.println("Entrez la valeur de c : ");
        double  c = clavier.nextDouble();

        return new Equation2Dg(a, b, c);
    }

    public static void resoudre(Scanner clavier){
        Equation2Dg eq = createEquation(clavier);

        if(eq.getA() == 0){
            if(eq.getC()==0 && eq.getB() == 0){
                System.out.println("IR");
            }
            else {
                if(eq.getC() == 0){
                    System.out.println("x = 0");
                }
                else{
                    System.out.println("Impossible");
                }
            }
        }
        else {
            if(eq.getDelta() == 0){
                System.out.println("Solution réelle double x = "+ ((-eq.getB())/2*eq.getA()));
            } else if (eq.getDelta()>0){
                double x1 = (-eq.getB() - Math.sqrt(eq.getDelta()) )/ 2 * eq.getA();
                double x2 = (-eq.getB() + Math.sqrt(eq.getDelta()) )/ 2 * eq.getA();
                System.out.println("Deux Solution réelle  x1 = " + x1 + " , x2 = "+ x2);

            }
            else{
                Complex x1 = new Complex((-eq.getB()/ 2 * eq.getA()), (- Math.sqrt(eq.getDelta()) ) / 2 * eq.getA());
                Complex x2 = ServiceComplexes.conjugate(x1);
                System.out.println("Deux Solution complexes  x1 = " + x1 + " , x2 = "+ x2);

            }
        }

    }

    public static void menuEquations(Scanner keyboardReader) {
    while (true) {
        System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_BLUE);
        System.out.print("""
            ===================================================
            =                 Equation Operations              =
            ===================================================
            = 1. Créer et résoudre une équation              =
            = 2. Quitter                                      =
            ===================================================
            """);
        System.out.print(ConsoleFontFormat.FontFormat_RESET);
        System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_GREEN);
        System.out.print("=> Entrez votre choix : ");
        
        int choice = keyboardReader.nextInt();
        keyboardReader.nextLine();  // Vider le buffer

        switch (choice) {
            case 1 -> {
                System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_PURPLE);
                resoudre(keyboardReader);
                System.out.print(ConsoleFontFormat.FontFormat_RESET);
            }
            case 2 -> {
                System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_RED);
                System.out.println("Retour au menu principal...");
                System.out.print(ConsoleFontFormat.FontFormat_RESET);
                return;
            }
            default -> {
                System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_RED);
                System.out.println("Choix invalide! Veuillez réessayer.");
                System.out.print(ConsoleFontFormat.FontFormat_RESET);
            }
        }
    }
}
}
