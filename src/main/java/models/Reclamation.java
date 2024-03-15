package models;

import java.util.Date;

public class Reclamation {
    private int id;
    private String description;
    private Date dateReclamation;
    private Utilisateur utilisateur;


    public Reclamation() {
        this.id = id;
        this.description = description;
        this.dateReclamation = dateReclamation;
        this.utilisateur = utilisateur;
    }


    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return "Reclamation{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dateReclamation=" + dateReclamation +
                ", utilisateur=" + utilisateur +
                '}';
    }
}

