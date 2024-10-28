package tps.tp2;

import java.util.Scanner;

import tps.tp2.bankati.modele.Account;
import tps.tp2.bankati.modele.Bank;
import tps.tp2.bankati.modele.Client;
import tps.tp2.bankati.service.BankService;
import tps.tp2.bankati.service.ClientServices;
import tps.tp2.bibliotheque.Bibliotheque;
import tps.tp2.equations.ServiceEquations;
import tps.tp2.formsGeometrique.Rectangle;
import tps.tp2.nombres.ServiceComplexes;
import tps.utils.ConsoleFontFormat;

public class TestTp2 {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank banque;
    private static BankService adminService;
    private static ClientServices clientService;
    private static Client clientConnecte;
    private static Account compteActuel;
    private static Bibliotheque bibliotheque;

    public static void main(String[] args) {

          initialiserBanque();
          bibliotheque = new Bibliotheque(10);
          boolean continuer = true;
  
          while (continuer) {
            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_BLUE);
            System.out.println("""
                ===================================================
                =                Application Java                 =
                ===================================================
                = 1. Exercice : Nombres Complexes                 =
                = 2. Exercice : Equations de deuxième degrés      =
                = 3. Exercice : Rectangle                         =
                = 4. Exercice : Bibliothèque                      =
                = 5. Exercice : Bankati                           =
                = 6. Quitter                                      = 
                ===================================================
                """);
            System.out.print(ConsoleFontFormat.FontFormat_RESET);
            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
            System.out.print("=> Entrez votre choix : ");
            
            int choix = scanner.nextInt();
            scanner.nextLine(); // Vider le buffer
            System.out.print(ConsoleFontFormat.FontFormat_RESET);
        
            switch (choix) {
                case 1:
                    menuNombresComplexes();
                    break;
                case 2:
                    menuDesEquations();
                    break;
                case 3:
                    rectangleMenu(scanner);
                    break;
                case 4: // Ajout de ce cas
                    bibliothequeMenu(scanner);
                    break;
                case 5:
                    menuBankati();
                    break;
                case 6: // Modification du numéro
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_RED);
                    System.out.println("Au revoir !");
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                    continuer = false;
                    break;
                default:
                    System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_RED);
                    System.out.println("Choix Invalide, Veuillez rééssayer !!");
                    System.out.print(ConsoleFontFormat.FontFormat_RESET);
                }
             }
        }

    private static void initialiserBanque() {
        // Initialisation de la banque avec des données de test
        banque = new Bank(1, "CIH Banque", "Agdal", "0123456789");
        adminService = new BankService(banque);

        // Créer quelques clients de test
        Client client1 = new Client(1, "EL mehdaoui", "Omar", "DG123", "Omar@email.com", "0611111111", "M");
        Client client2 = new Client(2, "EL omari", "Jihane", "UIO321", "Jihane@email.com", "0622222222", "F");
        
        banque.ajouterClient(client1);
        banque.ajouterClient(client2);
        
        // Créer des comptes pour les clients
        adminService.creerCompte(client1);
        adminService.creerCompte(client2);
    }

    private static void afficherMenuPrincipal() {
        System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_YELLOW);
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Services Administrateur");
        System.out.println("2. Services Client");
        System.out.println("3. Quitter");
        System.out.print(ConsoleFontFormat.FontFormat_RESET);
        System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
        System.out.print("Votre choix : ");
        
    }

    private static void menuAdmin() {
        boolean retourMenuPrincipal = false;

        while (!retourMenuPrincipal) {
            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_PURPLE);
            System.out.println("\n=== MENU ADMINISTRATEUR ===");
            System.out.println("1. Créer un compte pour un client");
            System.out.println("2. Lister tous les comptes");
            System.out.println("3. Créer un nouveau client");
            System.out.println("4. Retour au menu principal");
            System.out.print(ConsoleFontFormat.FontFormat_RESET);
            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Vider le buffer

            switch (choix) {
                case 1:
                    creerCompteClient();
                    break;
                case 2:
                    adminService.listerComptes();
                    break;
                case 3:
                    creerNouveauClient();
                    break;
                case 4:
                    retourMenuPrincipal = true;
                    break;
                default:
                        System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_RED);
                        System.out.println("Choix Invalide, Veuillez rééssayer !!");
                        System.out.print(ConsoleFontFormat.FontFormat_RESET);
            }
        }
    }

    private static void menuClient() {
        if (clientConnecte == null) {
            connecterClient();
        }
        if (clientConnecte == null) return; // Si la connexion a échoué

        if (compteActuel == null && clientConnecte.getNbComptes() > 0) {
            compteActuel = clientConnecte.getComptes()[0];
        }

        clientService = new ClientServices(banque, clientConnecte, compteActuel);

        boolean retourMenuPrincipal = false;
        while (!retourMenuPrincipal) {
            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_BLUE);
            System.out.println("\n=== MENU CLIENT ===");
            System.out.println("Client : " + clientConnecte.getNom() + " " + clientConnecte.getPrenom());
            if (compteActuel != null) {
                System.out.println("Compte actuel : " + compteActuel.getMatricule());
            }
            System.out.println("\n1. Voir solde");
            System.out.println("2. Faire un versement");
            System.out.println("3. Faire un retrait");
            System.out.println("4. Faire un virement");
            System.out.println("5. Voir l'historique des opérations");
            System.out.println("6. Modifier informations du compte");
            System.out.println("7. Changer de compte courant");
            System.out.println("8. Fermer le compte");
            System.out.println("9. Retour au menu principal");
            System.out.print(ConsoleFontFormat.FontFormat_RESET);
            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
            System.out.print("Votre choix : ");


            int choix = scanner.nextInt();
            scanner.nextLine(); // Vider le buffer

            switch (choix) {
                case 1:
                    clientService.afficherSolde();
                    break;
                case 2:
                    faireVersement();
                    break;
                case 3:
                    faireRetrait();
                    break;
                case 4:
                    faireVirement();
                    break;
                case 5:
                    clientService.historiqueOperations();
                    break;
                case 6:
                    modifierInfosCompte();
                    break;
                case 7:
                    changerCompteCourant();
                    break;
                case 8:
                    fermerCompteActuel();
                    break;
                case 9:
                    retourMenuPrincipal = true;
                    clientConnecte = null;
                    compteActuel = null;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }

    private static void connecterClient() {
        System.out.println("\nConnexion client");
        System.out.print("Entrez l'ID du client : ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Vider le buffer

        // Rechercher le client dans la banque
        for (int i = 0; i < banque.getNbClients(); i++) {
            Client client = banque.getClients()[i];
            if (client != null && client.getId() == id) {
                clientConnecte = client;
                break;
            }
        }

        if (clientConnecte == null) {
            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_RED);
            System.out.println("Client non trouvé !");
            System.out.print(ConsoleFontFormat.FontFormat_RESET);
        }
    }

    private static void creerCompteClient() {
        System.out.println("\nCréation d'un compte");
        System.out.print("ID du client : ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Vider le buffer

        // Rechercher le client
        Client client = null;
        for (int i = 0; i < banque.getNbClients(); i++) {
            if (banque.getClients()[i] != null && banque.getClients()[i].getId() == id) {
                client = banque.getClients()[i];
                break;
            }
        }

        if (client != null) {
            adminService.creerCompte(client);
            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
            System.out.println("Compte créé avec succès");
            System.out.print(ConsoleFontFormat.FontFormat_RESET);
        } else {
            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_RED);
            System.out.println("Client non trouvé !");
            System.out.print(ConsoleFontFormat.FontFormat_RESET);
        }
    }

    private static void creerNouveauClient() {
        System.out.println("\nCréation d'un nouveau client");
        System.out.print("ID : ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Vider le buffer
        
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        
        System.out.print("CIN : ");
        String cin = scanner.nextLine();
        
        System.out.print("Email : ");
        String email = scanner.nextLine();
        
        System.out.print("Téléphone : ");
        String tel = scanner.nextLine();
        
        System.out.print("Sexe (M/F) : ");
        String sex = scanner.nextLine();

        Client nouveauClient = new Client(id, nom, prenom, cin, email, tel, sex);
        banque.ajouterClient(nouveauClient);
            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
            System.out.println("Client créé avec succès");
            System.out.print(ConsoleFontFormat.FontFormat_RESET);
    }

    private static void faireVersement() {
        System.out.print("Montant à verser : ");
        double montant = scanner.nextDouble();
        scanner.nextLine(); // Vider le buffer
        clientService.versement(montant);
    }

    private static void faireRetrait() {
        System.out.print("Montant à retirer : ");
        double montant = scanner.nextDouble();
        scanner.nextLine(); // Vider le buffer
        clientService.retrait(montant);
    }

    private static void faireVirement() {
        System.out.print("Montant à virer : ");
        double montant = scanner.nextDouble();
        scanner.nextLine(); // Vider le buffer

        System.out.print("Numéro de compte destinataire : ");
        String matriculeCompte = scanner.nextLine();

        // Rechercher le compte destinataire
        Account compteDest = null;
        for (int i = 0; i < banque.getNbClients(); i++) {
            Client client = banque.getClients()[i];
            if (client != null) {
                for (int j = 0; j < client.getNbComptes(); j++) {
                    Account compte = client.getComptes()[j];
                    if (compte != null && compte.getMatricule().equals(matriculeCompte)) {
                        compteDest = compte;
                        break;
                    }
                }
            }
            if (compteDest != null) break;
        }

        if (compteDest != null) {
            clientService.virement(montant, compteDest);
        } else {
            System.out.println("Compte destinataire non trouvé");
        }
    }

    private static void modifierInfosCompte() {
        System.out.print("Nouveau numéro de téléphone : ");
        String nouveauTel = scanner.nextLine();
        
        System.out.print("Nouvel email : ");
        String nouveauEmail = scanner.nextLine();

        try {
            clientService.modifierInfosCompte(nouveauTel, nouveauEmail);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private static void changerCompteCourant() {
        if (clientConnecte.getNbComptes() <= 1) {
            System.out.println("Pas d'autres comptes disponibles");
            return;
        }

        System.out.println("Comptes disponibles :");
        for (int i = 0; i < clientConnecte.getNbComptes(); i++) {
            Account compte = clientConnecte.getComptes()[i];
            System.out.println(i + ". " + compte.getMatricule());
        }

        System.out.print("Choisir le numéro du compte : ");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Vider le buffer

        if (choix >= 0 && choix < clientConnecte.getNbComptes()) {
            compteActuel = clientConnecte.getComptes()[choix];
            clientService = new ClientServices(banque, clientConnecte, compteActuel);
            System.out.println("Compte courant changé avec succès");
        } else {
            System.out.println("Choix invalide");
        }
    }

    private static void fermerCompteActuel() {
        try {
            clientService.fermerCompte();
            compteActuel = null;
            if (clientConnecte.getNbComptes() > 0) {
                compteActuel = clientConnecte.getComptes()[0];
                clientService = new ClientServices(banque, clientConnecte, compteActuel);
            }
        } catch (IllegalStateException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

          

    private static void menuBankati() {
        boolean retourMenuPrincipal = false;

        while (!retourMenuPrincipal) {
            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
            System.out.println("\n=== MENU BANKATI ===");
            System.out.println("1. Services Administrateur");
            System.out.println("2. Services Client");
            System.out.println("3. Retour au menu principal");
            System.out.print(ConsoleFontFormat.FontFormat_RESET);
            System.out.print(ConsoleFontFormat.FontFormat_BOLD+ConsoleFontFormat.FontFormat_GREEN);
            System.out.print("Votre choix : ");


            int choix = scanner.nextInt();
            scanner.nextLine(); // Vider le buffer

            switch (choix) {
                case 1:
                    menuAdmin();
                    break;
                case 2:
                    menuClient();
                    break;
                case 3:
                    retourMenuPrincipal = true;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }
    

      private static void rectangleMenu(Scanner scanner) {
          Rectangle.menuRectangle(scanner); 
      }

      private static void bibliothequeMenu(Scanner scanner) {
          Bibliotheque.menuBiblio(scanner); 
      }

      private static void menuNombresComplexes() {
            ServiceComplexes.menuApplication(scanner);
      }

      private static void menuDesEquations() {
        ServiceEquations.menuEquations(scanner);
  }
}
