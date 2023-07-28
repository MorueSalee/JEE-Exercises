package fr.formation.biere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.biere.dal.util.ConnectionProvider;
import fr.formation.biere.bo.Biere;

public class BiereDAOImpl implements BiereDAO {
	final String SELECT_ALL = "SELECT * FROM Biere ORDER BY note DESC;";
	final String INSERT = "INSERT INTO Biere(" +
            "nom, couleur, brasserie, alcool, commentaire, note, prix) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?);";
	
	private Biere getResult(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("id");
        String nom = rs.getString("nom");
        String couleur = rs.getString("couleur");
        String brasserie = rs.getString("brasserie");
        Double alcool = rs.getDouble("alcool");
        String commentaire = rs.getString("commentaire");
        Integer note = rs.getInt("note");
        Double prix = rs.getDouble("prix");

        return new Biere(id, nom, couleur, brasserie, alcool, commentaire, note, prix);
    }
	
	private static void setResult(Biere biere, PreparedStatement pStmt) throws SQLException {
        pStmt.setString(1, biere.getNom());
        pStmt.setString(2, biere.getCouleur());
        pStmt.setString(3, biere.getBrasserie());
        pStmt.setDouble(4, biere.getAlcool());
        pStmt.setString(5, biere.getCommentaire());
        pStmt.setInt(6, biere.getNote());
        pStmt.setDouble(7, biere.getPrix());
    }

	@Override
	public void insert(Biere biere) throws DalException {
		try (Connection cnx = ConnectionProvider
				.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            setResult(biere, pStmt);

            pStmt.executeUpdate();
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                biere.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DalException((e.getMessage()));
        }		
	}

	@Override
	public List<Biere> getAll() throws DalException {
		List<Biere> sweetList = new ArrayList<>();


        try (Connection cnx = ConnectionProvider.getConnection()) {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                Biere a = getResult(rs);
                sweetList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DalException((e.getMessage()));
        }

        return sweetList;
	}
	
}
