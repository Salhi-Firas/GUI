package services;

import models.Avis;
import models.Personne;
import utils.MyDatabase;

import java.sql.*;

public class ServiceAvisImpl implements IServiceAvis {
    private Connection connection;
    public ServiceAvisImpl() {connection = MyDatabase.getInstance().getConnection();}

    @Override
    public void ajouterAvis(Avis avis) throws SQLException{
        String sql = "INSERT INTO avis (commentaire, note, utilisateur_id, produit_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, avis.getCommentaire());
            statement.setInt(2, avis.getNote());
            statement.setString(3, avis.getUtilisateur());
            statement.setInt(4, avis.getProduitId());
            statement.executeUpdate();
        }
    }

    @Override
    public Avis consulterAvis(int avisId) throws SQLException{
        Avis avis = null;
        String sql = "SELECT * FROM avis WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, avisId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    avis = new Avis();
                    avis.setId(resultSet.getInt("id"));
                    avis.setCommentaire(resultSet.getString("commentaire"));
                    avis.setNote(resultSet.getInt("note"));
                    avis.setUtilisateur(resultSet.getString("utilisateur"));
                    avis.setProduitId(resultSet.getInt("produit_id"));
                }
            }
        }
        return avis;
    }

    @Override
    public void mettreAJourAvis(Avis avis) throws SQLException{
        String sql = "UPDATE avis SET commentaire = ?, note = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, avis.getCommentaire());
            statement.setInt(2, avis.getNote());
            statement.setInt(3, avis.getId());
            statement.executeUpdate();
        }

    }

    @Override
    public void supprimerAvis(int avisId) throws SQLException{
        String sql = "DELETE FROM avis WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, avisId);
            statement.executeUpdate();
        }
    }
}
