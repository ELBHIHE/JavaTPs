package tps.tp2.bankati.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import tps.tp2.bankati.modele.*;

public class ClientServices {
    private Bank banque;
    private Client clientCourant;
    private Account compteCourant;
    
    public ClientServices(Bank banque, Client client, Account compte) {
        this.banque = banque;
        this.clientCourant = client;
        this.compteCourant = compte;
    }
    
    public void modifierInfosCompte(String nouveauTel, String nouveauEmail) {
        // Vérifier d'abord si le client et le compte existent
        if (clientCourant == null || compteCourant == null) {
            throw new IllegalStateException("Aucun client ou compte courant sélectionné");
        }

        // Vérifier si le compte est actif
        if (!compteCourant.isActif()) {
            System.out.println("Ce compte est fermé. Veuillez sélectionner un autre compte.");
            return;
        }

        // Procéder aux modifications si le compte est actif
        boolean modifie = false;
        StringBuilder modifications = new StringBuilder();

        // Modifier le téléphone si nécessaire
        if (nouveauTel != null && !nouveauTel.trim().isEmpty() && !nouveauTel.equals(clientCourant.getTel())) {
            clientCourant.setTel(nouveauTel);
            modifications.append("Téléphone modifié de ").append(clientCourant.getTel())
                       .append(" à ").append(nouveauTel).append("; ");
            modifie = true;
        }

        // Modifier l'email si nécessaire
        if (nouveauEmail != null && !nouveauEmail.trim().isEmpty() && !nouveauEmail.equals(clientCourant.getEmail())) {
            if (nouveauEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                clientCourant.setEmail(nouveauEmail);
                modifications.append("Email modifié de ").append(clientCourant.getEmail())
                           .append(" à ").append(nouveauEmail);
                modifie = true;
            } else {
                System.out.println("Format d'email invalide");
            }
        }

        // Créer un log si des modifications ont été effectuées
        if (modifie) {
            Log log = new Log(
                LocalDate.now(),
                LocalTime.now(),
                TypeLog.MODIFICATION,
                modifications.toString()
            );
            compteCourant.ajouterOperation(log);
            System.out.println("Modifications effectuées avec succès");
        } else {
            System.out.println("Aucune modification n'a été effectuée");
        }
    }
    
    public void listerSesComptes() {
        System.out.println("Comptes de " + clientCourant.getNom() + ":");
        for (int i = 0; i < clientCourant.getNbComptes(); i++) {
            Account compte = clientCourant.getComptes()[i];
            System.out.println("Compte " + compte.getMatricule() + 
                ", Solde: " + compte.getSolde());
        }
    }
    
    public void fermerCompte() {
        if (clientCourant == null || compteCourant == null) {
            throw new IllegalStateException("Aucun client ou compte courant sélectionné");
        }

        // Vérifier si le compte n'est pas déjà fermé
        if (!compteCourant.isActif()) {
            System.out.println("Ce compte est déjà fermé");
            return;
        }

        // Vérifier le solde
        if (compteCourant.getSolde() != 0) {
            System.out.println("Impossible de fermer le compte. Le solde doit être à zéro. Solde actuel: " 
                             + compteCourant.getSolde());
            return;
        }

        // Fermer le compte
        compteCourant.setActif(false);
        compteCourant.setDateFermeture(LocalDateTime.now());

        // Créer un log pour la fermeture
        Log log = new Log(
            LocalDate.now(),
            LocalTime.now(),
            TypeLog.SUPPRESSION,
            "Fermeture du compte " + compteCourant.getMatricule()
        );
        compteCourant.ajouterOperation(log);

        System.out.println("Le compte a été fermé avec succès");
    }
    
    public void versement(double montant) {
        if (montant > 0) {
            compteCourant.setSolde(compteCourant.getSolde() + montant);
            Log log = new Log(
                LocalDate.now(),
                LocalTime.now(),
                TypeLog.VERSSEMENT,
                "Versement de " + montant
            );
            compteCourant.ajouterOperation(log);
        }
    }
    
    public void retrait(double montant) {
        if (montant > 0 && compteCourant.getSolde() >= montant) {
            compteCourant.setSolde(compteCourant.getSolde() - montant);
            Log log = new Log(
                LocalDate.now(),
                LocalTime.now(),
                TypeLog.RETRAIT,
                "Retrait de " + montant
            );
            compteCourant.ajouterOperation(log);
        }
    }
    
    public void virement(double montant, Account compteDest) {
        if (montant > 0 && compteCourant.getSolde() >= montant) {
            compteCourant.setSolde(compteCourant.getSolde() - montant);
            compteDest.setSolde(compteDest.getSolde() + montant);
            
            Log logDebit = new Log(
                LocalDate.now(),
                LocalTime.now(),
                TypeLog.VIREMENT,
                "Virement sortant de " + montant + " vers " + compteDest.getMatricule()
            );
            Log logCredit = new Log(
                LocalDate.now(),
                LocalTime.now(),
                TypeLog.VIREMENT,
                "Virement entrant de " + montant + " depuis " + compteCourant.getMatricule()
            );
            
            compteCourant.ajouterOperation(logDebit);
            compteDest.ajouterOperation(logCredit);
        }
    }
    
    public void historiqueOperations() {
        System.out.println("Historique des opérations du compte " + 
            compteCourant.getMatricule() + ":");
        for (Log operation : compteCourant.getOperations()) {
            if (operation != null) {
                System.out.println(operation);
            }
        }
    }
    
    public void afficherSolde() {
        System.out.println("Solde du compte " + compteCourant.getMatricule() + 
            ": " + compteCourant.getSolde());
    }
    
    public void changerCompteCourant(Account nouveauCompte) {
        if (nouveauCompte.getProprietaire().getId() == clientCourant.getId()) {
            this.compteCourant = nouveauCompte;
        }
    }
}
