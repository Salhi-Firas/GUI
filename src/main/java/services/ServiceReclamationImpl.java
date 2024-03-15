package services;

import models.Reclamation;
import utils.MyDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceReclamationImpl implements IServiceReclamation{
    private Connection connection;
    public ServiceReclamationImpl() {connection = MyDatabase.getInstance().getConnection();}
    @Override
    public void soumettreReclamation(Reclamation reclamation) throws SQLException {
        String sql = "INSERT INTO reclamations (description, utilisateur_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, reclamation.getDescription());
            statement.setString(2, reclamation.getUtilisateur());
            statement.executeUpdate();
        }
    }

    @Override
    public Reclamation consulterReclamation(int reclamationId) throws SQLException{
        Reclamation reclamation = null;
        String sql = "SELECT * FROM reclamations WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reclamationId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    reclamation = new Reclamation();
                    reclamation.setId(resultSet.getInt("id"));
                    reclamation.setDescription(resultSet.getString("description"));
                    reclamation.setUtilisateur(resultSet.getString("utilisateur"));

                }
            }
        }
        return reclamation;
    }

    @Override
    public void traiterReclamation(Reclamation reclamation) throws SQLException{
        String sql = "UPDATE reclamations SET traitee = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, true);
            statement.setInt(2, reclamation.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void supprimerReclamation(int reclamationId) throws SQLException{
        String sql = "DELETE FROM reclamations WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reclamationId);
            statement.executeUpdate();
        }
    }
}
