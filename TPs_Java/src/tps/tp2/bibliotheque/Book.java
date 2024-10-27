package tps.tp2.bibliotheque;

public class Book {

    private static int compteurId = 1;
	
	private int id;
    private String titre;
    private String auteur;
    private double prix;

    public Book(String titre, String auteur, double prix) {
        setId(compteurId++);
        setTitre(titre);
        setAuteur(auteur);
        setPrix(prix);
    }
    
    public Book(String titre) {
    	setTitre(titre);
    }
    
    public Book() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", prix=" + prix + "]";
    }

}
