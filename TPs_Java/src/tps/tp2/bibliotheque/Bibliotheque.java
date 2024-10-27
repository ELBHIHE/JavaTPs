package tps.tp2.bibliotheque;

import java.util.Scanner;

import tps.utils.ConsoleFontFormat;

public class Bibliotheque {
	
	private int id;
	private Book[] books;
	
	public Bibliotheque(int tailleMax) {
		books = new Book[tailleMax];
        id = 0;
    }
	
	public int getNombreDeLivres() {
        return id;
    }

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Book[] getBooks() {
		return books;
	}
	public void setBooks(Book[] books) {
		this.books = books;
	}
	

    public void setLivre(int position, Book book) {
        if (position >= 0 && position < id) {
            books[position] = book;
        } else {
            System.out.println("Position invalide.");
        }
    }
    
    @Override
    public String toString() {
        if (id == 0) {
            return "La bibliotheque est vide.";
        }
        StringBuilder sb = new StringBuilder("Contenu de la bibliotheque :\n");
        for (int i = 0; i < id; i++) {
            sb.append((i + 1) + ". " + books[i].toString() + "\n");
        }
        return sb.toString();
    }
	
    public static void menuBiblio(Scanner scanner) {
        Bibliotheque bibliotheque = new Bibliotheque(10); 
        ServiceLibrary service = new ServiceLibrary();

        while (true) {
            System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_BLUE);
            System.out.println("Menu de l'exercice Bibliotheque:");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Modifier un livre");
            System.out.println("3. Supprimer un livre");
            System.out.println("4. Chercher un livre");
            System.out.println("5. Afficher tous les livres");
            System.out.println("6. Retour au menu principal");
            
            System.out.print(ConsoleFontFormat.FontFormat_RESET);
            System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_GREEN);
            System.out.println("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_GREEN);
                    System.out.print("Entrez le titre du livre a ajouter : ");
                    String titre = scanner.nextLine();
                    System.out.print("Entrez l'auteur du livre a ajouter : ");
                    String auteur = scanner.nextLine();
                    System.out.print("Entrez le prix du livre a ajouter : ");
                    double prix = scanner.nextDouble();
                    
                    Book livreAAjouter = new Book(titre, auteur, prix);
                    service.ajouter(bibliotheque, livreAAjouter);
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    break;
                case 2:
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_GREEN);
                    System.out.print("Entrez l'ID du livre a modifier : ");
                    int idModifie = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Entrez le nouveau titre du livre : ");
                    String nouveauTitre = scanner.nextLine();
                    System.out.print("Entrez le nouvel auteur du livre : ");
                    String nouvelAuteur = scanner.nextLine();
                    System.out.print("Entrez le nouveau prix du livre : ");
                    double nouveauPrix = scanner.nextDouble();
                    
                    Book livreModifie = new Book(nouveauTitre, nouvelAuteur, nouveauPrix);
                    livreModifie.setId(idModifie); 
                    service.modifier(bibliotheque, livreModifie);
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    break;
                case 3:
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_GREEN);
                    System.out.print("Entrez l'ID du livre a supprimer : ");
                    int idSupprime = scanner.nextInt();
                    scanner.nextLine(); 
                    Book livreASupprimer = new Book();
                    livreASupprimer.setId(idSupprime);
                    service.supprimer(bibliotheque, livreASupprimer);
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    break;
                case 4:
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_GREEN);
                    System.out.print("Entrez l'ID du livre a chercher : ");
                    int idRecherche = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Entrez le titre du livre a chercher : ");
                    String titreRecherche = scanner.nextLine();
                    System.out.print("Entrez l'auteur du livre a chercher : ");
                    String auteurRecherche = scanner.nextLine();
                    
                    Book livreRecherche = new Book(titreRecherche, auteurRecherche, 0); 
                    service.chercherV2(bibliotheque, livreRecherche);
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    break;
                case 5:
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD + ConsoleFontFormat.FontFormat_GREEN);
                    System.out.println(bibliotheque.toString());
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    break;
                case 6:
                    return; 
                default:
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_RED);
                    System.out.println("Choix Invalide, Veuillez rééssayer !!");
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
            }
        }
    }

}
