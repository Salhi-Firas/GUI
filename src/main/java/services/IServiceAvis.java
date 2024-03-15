package services;

import models.Avis;

import java.sql.SQLException;

public interface IServiceAvis {
    void ajouterAvis(Avis avis) throws SQLException;
    Avis consulterAvis(int avisId) throws SQLException;
    void mettreAJourAvis(Avis avis) throws SQLException;
    void supprimerAvis(int avisId) throws SQLException;
}
