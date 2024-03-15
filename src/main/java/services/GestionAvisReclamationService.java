package services;

import models.Avis;
import models.AvisNonTrouveException;
import models.Reclamation;

import java.util.ArrayList;
import java.util.List;

public class GestionAvisReclamationService {
    private List<Avis> avisList;
    private List<Reclamation> reclamationsList;

    public GestionAvisReclamationService() {
        this.avisList = new ArrayList<>();
        this.reclamationsList = new ArrayList<>();
    }



    public void ajouterAvis(Avis avis) {
        avisList.add(avis);
    }

    public Avis consulterAvis(int avisId) {
        return avisList.stream()
                .filter(avis -> avis.getId() == avisId)
                .findFirst()
                .orElse(null);
    }

    public void mettreAJourAvis(Avis avis) throws AvisNonTrouveException {
        for (int i = 0; i < avisList.size(); i++) {
            Avis a = avisList.get(i);
            if (a.getId() == avis.getId()) {
                avisList.set(i, avis); // Remplacer l'avis existant par le nouvel avis

            }
        }
        throw new AvisNonTrouveException("L'avis avec l'ID " + avis.getId() + " n'a pas été trouvé.");
    }

    public void supprimerAvis(int avisId) {
        avisList.removeIf(avis -> avis.getId() == avisId);
    }

    // Opérations CRUD pour les Réclamations

    public void soumettreReclamation(Reclamation reclamation) {
        reclamationsList.add(reclamation);
    }

    public Reclamation consulterReclamation(int reclamationId) {
        return reclamationsList.stream()
                .filter(reclamation -> reclamation.getId() == reclamationId)
                .findFirst()
                .orElse(null);
    }//rechercher une réclamation
    // spécifique dans la liste des réclamations
    // en fonction de son identifiant. Si une réclamation correspondante est trouvée,
    // elle est retournée pour être utilisée dans d'autres parties de votre application.
    // Sinon, null est retourné, indiquant l'absence de réclamation correspondante.

    public void traiterReclamation(Reclamation reclamation) {
        System.out.println("Réclamation traitée : " + reclamation.getDescription());
    }

    public void supprimerReclamation(int reclamationId) {
        reclamationsList.removeIf(reclamation -> reclamation.getId() == reclamationId);
    }



    public List<Avis> getAvisList() {
        return new ArrayList<>(avisList);
    }

    public List<Reclamation> getReclamationsList() {
        return new ArrayList<>(reclamationsList);
    }
}

