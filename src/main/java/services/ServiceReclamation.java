package services;

import models.Reclamation;

public class ServiceReclamation {


    public void soumettreReclamation(GestionAvisReclamationService gestionService, Reclamation reclamation) {
        gestionService.soumettreReclamation(reclamation);
    }

    public Reclamation consulterReclamation(GestionAvisReclamationService gestionService, int reclamationId) {
        return gestionService.consulterReclamation(reclamationId);
    }

    public void traiterReclamation(GestionAvisReclamationService gestionService, Reclamation reclamation) {
        gestionService.traiterReclamation(reclamation);
    }

    public void supprimerReclamation(GestionAvisReclamationService gestionService, int reclamationId) {
        gestionService.supprimerReclamation(reclamationId);
    }

}

