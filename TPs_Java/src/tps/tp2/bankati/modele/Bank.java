package tps.tp2.bankati.modele;

public class Bank {
    private Long id;
    private String nom;
    private String adresse;
    private String tel;
    private Client[] clients;  
    private int nbClients;

    public Bank(String nom, String adresse, String tel) {
        setNom(nom);
        setAdresse(adresse);
        setTel(tel);
        this.clients = new Client[100];  
        this.nbClients = 0;
    }

    public Bank(long id, String nom, String adresse, String tel) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.clients = new Client[100];
        this.nbClients = 0;
    }

    public void ajouterClient(Client client) {
        if (nbClients < clients.length) {
            clients[nbClients++] = client;
        }
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }

    public Client[] getClients() { return clients; }
    public void setClients(Client[] clients) { this.clients = clients; }

    public int getNbClients() { return nbClients; }

    @Override
    public String toString() {
        return "Banque: " + nom + " Adresse: " + adresse + " Tel: " + tel;
    }
}

