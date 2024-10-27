package tps.tp2.bibliotheque;

public class ServiceLibrary {

    
    public static void ajouter(Bibliotheque bibliotheque, Book book) {
        Book[] books = bibliotheque.getBooks();
        int nombreDeLivres = bibliotheque.getNombreDeLivres();

        if (nombreDeLivres >= books.length) {
            System.out.println("Bibliotheque pleine, impossible d'ajouter plus de livres.");
            return;
        }
        for (int i = 0; i < nombreDeLivres; i++) {
            if (books[i].getId() == book.getId()) {
                System.out.println("Un livre avec cet ID existe deja.");
                return;
            }
        }
        books[nombreDeLivres] = book;
        bibliotheque.setId(nombreDeLivres + 1); 
        System.out.println("Livre ajoute : " + book.toString());
    }

    public static void modifier(Bibliotheque bibliotheque, Book livreModifie) {
        Book[] books = bibliotheque.getBooks();
        boolean livreTrouve = false;

        for (int i = 0; i < bibliotheque.getNombreDeLivres(); i++) {
            if (books[i].getId() == livreModifie.getId()) {
                books[i] = livreModifie;
                livreTrouve = true;
                System.out.println("Livre modifie : " + livreModifie.toString());
                break;
            }
        }

        if (!livreTrouve) {
            System.out.println("Livre non trouve pour modification.");
        }
    }

    public static void supprimer(Bibliotheque bibliotheque, Book livre) {
        Book[] books = bibliotheque.getBooks();
        int nombreDeLivres = bibliotheque.getNombreDeLivres();
        boolean livreTrouve = false;

        for (int i = 0; i < nombreDeLivres; i++) {
            if (books[i].getId() == livre.getId()) {
                livreTrouve = true;

                for (int j = i; j < nombreDeLivres - 1; j++) {
                    books[j] = books[j + 1];
                }

                books[nombreDeLivres - 1] = null;
                bibliotheque.setId(nombreDeLivres - 1);
                System.out.println("Livre supprime : " + livre.toString());
                break;
            }
        }

        if (!livreTrouve) {
            System.out.println("Livre non trouve dans la bibliotheque.");
        }
    }


    public static void chercher(Bibliotheque bibliotheque, Book livreRecherche) {
        Book[] books = bibliotheque.getBooks();
        boolean livreTrouve = false;

        for (int i = 0; i < bibliotheque.getNombreDeLivres(); i++) {
            if (books[i].getTitre().equals(livreRecherche.getTitre()) && 
                books[i].getAuteur().equals(livreRecherche.getAuteur())) {
                livreTrouve = true;
                System.out.println("Livre trouve : " + books[i].toString());
                break;
            }
        }

        if (!livreTrouve) {
            System.out.println("Livre non trouve dans la bibliotheque.");
        }
    }

    public static void chercherV2(Bibliotheque bibliotheque, Book livre) {
        if (bibliotheque == null || livre == null) {
            System.out.println("La bibliotheque ou le livre ne peut pas etre null.");
            return;
        }
        boolean found = false;

        for (int i = 0; i < bibliotheque.getNombreDeLivres(); i++) {
            Book livreActuel = bibliotheque.getBooks()[i];
            if (livreActuel.getTitre().equals(livre.getTitre()) && 
                livreActuel.getAuteur().equals(livre.getAuteur())) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Le livre \"" + livre.getTitre() + "\" est disponible dans la bibliotheque.");
        } else {
            System.out.println("Le livre \"" + livre.getTitre() + "\" n'est pas disponible dans la bibliotheque.");
        }
    }
}

