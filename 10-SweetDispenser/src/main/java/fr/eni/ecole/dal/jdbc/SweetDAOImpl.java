package fr.eni.ecole.dal.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.bo.Sweet;
import fr.eni.ecole.dal.DAO;
import fr.eni.ecole.dal.DalException;
import fr.eni.ecole.dal.util.ConnectionProvider;

public class SweetDAOImpl implements DAO {
	final String SELECT_ALL = "SELECT * FROM Sweet;";
    final String SELECT_BY_NAME = "SELECT * FROM Sweet WHERE name=?;";
    final String SELECT_BY_MOT_CLE = "SELECT * FROM Sweet WHERE description LIKE ?;";
    final String SELECT_BY_ID = "SELECT * FROM Sweet WHERE id=?;";
    final String INSERT = "INSERT INTO Sweet(" +
            "name, description, taste, price, quantity) " +
            "VALUES(?, ?, ?, ?, ?);";
    final String UPDATE = "UPDATE Sweet SET name = ?, description = ?, taste = ?, price = ?, " +
            "quantity = ? WHERE id = ?";
    final String DELETE = "DELETE FROM Sweet WHERE id = ?";
	
    private Sweet getResult(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("id");
        String name = rs.getString("name");
        String description = rs.getString("description");
        String taste = rs.getString("taste");
        Float price = rs.getFloat("price");
        Integer quantity = rs.getInt("quantity");

        return new Sweet(id, name, description, taste, price, quantity);
    }
    
    private static void setResult(Sweet sweet, PreparedStatement pStmt) throws SQLException {
        pStmt.setString(1, sweet.getName());
        pStmt.setString(2, sweet.getDescription());
        pStmt.setString(3, sweet.getTaste());
        pStmt.setFloat(4, sweet.getPrice());
        pStmt.setInt(5, sweet.getQuantity());
    }

	@Override
	public Sweet selectById(Integer id) throws DalException, ClassNotFoundException {
		Sweet sweet = null;

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_ID);
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                sweet = getResult(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DalException((e.getMessage()));
        }

        return sweet;
	}
	
	@Override
	public List<Sweet> selectAll() throws DalException, ClassNotFoundException {
		List<Sweet> sweetList = new ArrayList<>();


        try (Connection cnx = ConnectionProvider.getConnection()) {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                Sweet a = getResult(rs);
                sweetList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DalException((e.getMessage()));
        }

        return sweetList;
	}

	@Override
	public void update(Sweet sweet) throws DalException, ClassNotFoundException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(UPDATE, PreparedStatement.RETURN_GENERATED_KEYS);
            setResult(sweet, pStmt);
            pStmt.setInt(1, sweet.getId());
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DalException((e.getMessage()));
        }
	}

	@Override
	public void insert(Sweet sweet) throws DalException, ClassNotFoundException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            setResult(sweet, pStmt);

            pStmt.executeUpdate();
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                sweet.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DalException((e.getMessage()));
        }
	}

	@Override
	public void delete(int id) throws DalException, ClassNotFoundException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(DELETE, PreparedStatement.RETURN_GENERATED_KEYS);
            pStmt.setInt(1, id);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DalException((e.getMessage()));
        }
	}
}
