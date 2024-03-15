package services;

import models.Avis;
import models.Reclamation;

import java.sql.SQLException;

public interface IServiceReclamation {
    void soumettreReclamation(Reclamation reclamation) throws SQLException;
    Reclamation consulterReclamation(int reclamationId) throws SQLException;
    void traiterReclamation(Reclamation reclamation) throws SQLException;
    void supprimerReclamation(int reclamationId) throws SQLException;
}
