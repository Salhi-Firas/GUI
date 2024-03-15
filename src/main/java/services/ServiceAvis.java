package services;
import models.Avis;
import models.AvisNonTrouveException;

import java.util.List;

public class ServiceAvis {


    public void ajouterAvis(GestionAvisReclamationService gestionService, Avis avis) {
        gestionService.ajouterAvis(avis);
    }

    public Avis consulterAvis(GestionAvisReclamationService gestionService, int avisId) {
        return gestionService.consulterAvis(avisId);
    }

    public void mettreAJourAvis(GestionAvisReclamationService gestionService, Avis avis) throws AvisNonTrouveException {
        try {
            gestionService.mettreAJourAvis(avis);
        } catch (AvisNonTrouveException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    public void supprimerAvis(GestionAvisReclamationService gestionService, int avisId) {
        gestionService.supprimerAvis(avisId);
    }

}


