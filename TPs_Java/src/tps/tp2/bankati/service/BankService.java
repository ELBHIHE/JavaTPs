package tps.tp2.bankati.service;

import java.time.LocalDate;
import java.time.LocalTime;

import tps.tp2.bankati.modele.*;

public class BankService {
    private Bank banque;
    
    public BankService(Bank banque) {
        this.banque = banque;
    }
    
    public void creerCompte(Client client) {
        if (client.getNbComptes() < 3) {
            String matricule = "CPT" + System.currentTimeMillis();
            Account compte = new Account(matricule, client);
            client.ajouterCompte(compte);
            
            // Ajouter un log de création
            Log log = new Log(
                LocalDate.now(),
                LocalTime.now(),
                TypeLog.CREATION,
                "Création du compte " + matricule
            );
            compte.ajouterOperation(log);
        }
    }
    
    public void listerComptes() {
        for (int i = 0; i < banque.getNbClients(); i++) {
            Client client = banque.getClients()[i];
            System.out.println("Client: " + client.getNom());
            for (int j = 0; j < client.getNbComptes(); j++) {
                Account compte = client.getComptes()[j];
                System.out.println("  Compte: " + compte.getMatricule() + 
                    ", Solde: " + compte.getSolde());
            }
        }
    }
}
