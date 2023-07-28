package fr.formation.task.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.formation.task.bo.Task;
import fr.formation.task.dal.util.ConnectionProvider;

public class TaskDAOImpl implements TaskDAO {
	final String SELECT = "SELECT id_task, label, dstart, dend, priority, is_done FROM task";
	final String INSERT = "INSERT INTO task (label, dstart, dend, priority, is_done) VALUES (?,?,?,?,?)";

	@Override
	public void insert(Task task) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, task.getLabel());
			stmt.setTimestamp(2, Timestamp.valueOf(task.getStart()));
			stmt.setTimestamp(3, Timestamp.valueOf(task.getEnd()));
			stmt.setInt(4, task.getPriority());
			stmt.setInt(5,task.getIsDone()?1:0);
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs= stmt.getGeneratedKeys();
				if(rs.next()) {
					task.setIdTask(rs.getInt(1));
				}
			}
		}
		catch(SQLException e) {
			throw new DALException("ms_insert");
		}
	
	}

	@Override
	public List<Task> getAll() throws DALException {
		List<Task> result= new ArrayList<>();
		
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Task task = new Task(rs.getString("label"),
							rs.getTimestamp("dstart").toLocalDateTime(),
							rs.getTimestamp("dend").toLocalDateTime(),
							rs.getInt("priority"),
							rs.getInt("is_done")==1?true:false
						);
				task.setIdTask(rs.getInt("id_task"));
				result.add(task);
			}
		}
		catch(SQLException e) {
			throw new DALException("ms_insert");
		}
		
		return result;
	}
}
