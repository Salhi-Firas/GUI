package models;

import java.util.Date;

public class Avis {
    private int id;
    private String commentaire;
    private int note;
    private Date dateAvis;
    private String utilisateur;
    private int produitId;

    public Avis() {
        this.id = id;
        this.commentaire = commentaire;
        this.note = note;
        this.dateAvis = dateAvis;
        this.utilisateur = utilisateur;
        this.produitId= produitId;
    }


    public int getId() {
        return id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public int getNote() {
        return note;
    }

    public Date getDateAvis() {
        return dateAvis;
    }

    public String getUtilisateur() {
        return utilisateur;
    }
    public int getProduitId() {return produitId;}

    public void setId(int id) {
        this.id = id;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setDateAvis(Date dateAvis) {
        this.dateAvis = dateAvis;
    }

    public void setUtilisateur(String utilisateur) {this.utilisateur = utilisateur;}
    public void setProduitId(int produitId) {this.produitId = produitId;}
    @Override
    public String toString() {
        return "Avis{" +
                "id=" + id +
                ", commentaire='" + commentaire + '\'' +
                ", note=" + note +
                ", dateAvis=" + dateAvis +
                ", utilisateur=" + utilisateur +
                ", produitId=" + produitId +
                '}';
    }


}
