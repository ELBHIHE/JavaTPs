package tps.tp2.bankati.modele;

import java.time.LocalDateTime;

public class Account {
    private String matricule;
    private double solde;
    private Log[] operations;  
    private Client proprietaire;
    private LocalDateTime dateDeCreation;
    private int nbOperations;
    private static boolean actif = true;
    private LocalDateTime dateFermeture;

    public Account(Client proprietaire, double solde) {
        setProprietaire(proprietaire);
        setSolde(solde);
        this.dateDeCreation = LocalDateTime.now();
        this.operations = new Log[100];
        this.nbOperations = 0;
        this.dateFermeture = null;

    }

    public Account(String matricule, Client proprietaire) {
        this.matricule = matricule;
        this.proprietaire = proprietaire;
        this.solde = 0;
        this.dateDeCreation = LocalDateTime.now();
        this.operations = new Log[100];
        this.nbOperations = 0;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
    
    public void setDateFermeture(LocalDateTime dateFermeture) {
        this.dateFermeture = dateFermeture;
    }

    public void ajouterOperation(Log operation) {
        if (nbOperations < operations.length) {
            operations[nbOperations++] = operation;
        }
    }

    // Getters et Setters
    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }

    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }

    public Log[] getOperations() { return operations; }
    public void setOperations(Log[] operations) { this.operations = operations; }

    public Client getProprietaire() { return proprietaire; }
    public void setProprietaire(Client proprietaire) { this.proprietaire = proprietaire; }

    public LocalDateTime getDateDeCreation() { return dateDeCreation; }

    @Override
    public String toString() {
        return "Compte: " + matricule + " Solde: " + solde;
    }
}
