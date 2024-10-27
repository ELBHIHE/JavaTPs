package tps.tp2.formsGeometrique;

import java.util.Scanner;

import tps.utils.ConsoleFontFormat;

public class Rectangle {
	
	private double hauteur;
	private double largeur;
	
	
	public double getHauteur() {
		return hauteur;
	}
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	public double getLargeur() {
		return largeur;
	}
	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}
	
	public Rectangle(double hauteur, double largeur) {
		setHauteur(hauteur);
		setLargeur(largeur);
	}

	public Rectangle() {}
	
	public Rectangle(Rectangle other) {
		setHauteur(other.hauteur);
		setLargeur(other.largeur);
	}
	
	@Override
	public String toString() {
		return "Rectangle : hauteur = "+hauteur+" largeur = "+largeur;
	}
	
	public double surface() {
		double surface = largeur * hauteur;
		return surface;
	}
	
	public double perimetre() {
		double perimetre = 2 * (largeur + hauteur);
		return perimetre;
	}
	
	public boolean estCarrée() {
		if(largeur == hauteur) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public static void menuRectangle(Scanner scanner) {
        Rectangle rectangle = null; 

        while (true) {
            System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_BLUE);
            System.out.println("Menu de l'exercice Rectangle:");
            System.out.println("1. Creer un rectangle");
            System.out.println("2. Calculer la surface");
            System.out.println("3. Calculer le perimetre");
            System.out.println("4. Verifier si le rectangle est carree");
            System.out.println("5. Retour au menu principal");
            System.out.print(ConsoleFontFormat.FontFormat_RESET);
            System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_GREEN);
            System.out.print("Entrez votre choix : ");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_GREEN);
                    System.out.print("Entrez la hauteur: ");
                    double hauteur = scanner.nextDouble();
                    System.out.print("Entrez la largeur: ");
                    double largeur = scanner.nextDouble();
                    rectangle = new Rectangle(hauteur, largeur);
                    System.out.println("Rectangle cree avec succes !");
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    break;
                case 2:
                    if (rectangle != null) {
                        System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_GREEN);
                        System.out.println("Surface: " + rectangle.surface());
                        System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    } else {
                        System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_RED);
                        System.out.println("Veuillez d'abord creer un rectangle.");
                        System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    }
                    break;
                case 3:
                    if (rectangle != null) {
                        System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_GREEN);
                        System.out.println("Perimetre: " + rectangle.perimetre());
                        System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    } else {
                        System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_RED);
                        System.out.println("Veuillez d'abord creer un rectangle.");
                        System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    }
                    break;
                case 4:
                    if (rectangle != null) {
                        if (rectangle.estCarrée()) {
                            System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_GREEN);
                            System.out.println("Le rectangle est carre.");
                            System.out.print(ConsoleFontFormat.FontFormat_RESET);
                        } else {
                            System.out.println("Le rectangle n'est pas carre.");
                        }
                    } else {
                        System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_RED);
                        System.out.println("Veuillez d'abord creer un rectangle.");
                        System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    }
                    break;
                case 5:
                    return; 
                default:
                        System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_RED);
                        System.out.println("Choix Invalide, Veuillez rééssayer !!");
                        System.out.print(ConsoleFontFormat.FontFormat_RESET);
            }
        }
    }
}
