package tps.tp2.bankati.modele;

public class Client {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String cin;
    private String tel;
    private String sexe;
    private Account[] comptes;  
    private int nbComptes;
    private int nbComptesActifs;

    public Client(String nom, String prenom, String email, String cin, String tel, String sexe) {
        setNom(prenom);
        setPrenom(prenom);
        setEmail(email);
        setCin(cin);
        setTel(tel);
        setSexe(sexe);
        this.comptes = new Account[3];
        this.nbComptes = 0;
        this.nbComptesActifs = 0;
    }

    public Client(long id, String nom, String prenom, String cin, String email, String tel, String sex) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.email = email;
        this.tel = tel;
        this.sexe = sex;
        this.comptes = new Account[3];
        this.nbComptes = 0;
    }

    public Client() {}

    public void ajouterCompte(Account compte) {
        if (nbComptes < comptes.length) {
            comptes[nbComptes++] = compte;
        }
    }

    public void decrementNbComptesActifs() {
        this.nbComptesActifs--;
    }
    
    public int getNbComptesActifs() {
        return nbComptesActifs;
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCin() { return cin; }
    public void setCin(String cin) { this.cin = cin; }

    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }

    public String getSexe() { return sexe; }
    public void setSexe(String sexe) { this.sexe = sexe; }

    public Account[] getComptes() { return comptes; }
    public void setComptes(Account[] comptes) { this.comptes = comptes; }

    public int getNbComptes() { return nbComptes; }

    @Override
    public String toString() {
        return nom + " " + prenom;
    }
}
