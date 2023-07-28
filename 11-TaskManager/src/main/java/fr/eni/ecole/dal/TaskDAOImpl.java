package fr.eni.ecole.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.bo.Task;
import fr.eni.ecole.dal.util.ConnectionProvider;

public class TaskDAOImpl implements TaskDAO {
	final String SELECT = "SELECT idTask, label,dtStart,dtEnd,hStart,hEnd,priority,isDone FROM Task";
    final String INSERT = "INSERT INTO Task (label,dtStart,dtEnd,hStart,hEnd,priority,isDone) VALUES (?,?,?,?,?,?,?)";
    final String SELECT_BY_NOT_DONE_ORDER_PRIORITY = "SELECT idTask, label,dtStart,dtEnd,hStart,hEnd,priority,isDone FROM Task"
    		+ " WHERE isDone = 'false' ORDER BY priority ASC";
    
    @Override
    public void insert(Task task) throws DalException, ClassNotFoundException{
    	try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
				stmt.setString(1, task.getLabel());
			 	stmt.setDate(2, Date.valueOf(task.getDtStart()));
		        stmt.setDate(3, Date.valueOf(task.getDtEnd()));
		        stmt.setTime(4, Time.valueOf(task.gethStart()));
		        stmt.setTime(5, Time.valueOf(task.gethEnd()));
		        stmt.setInt(6, task.getPriority());
		        stmt.setBoolean(7, task.getIsDone());
		        int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs= stmt.getGeneratedKeys();
				if(rs.next()) {
					task.setIdTask(rs.getInt(1));
				}
			}
		}
		catch(SQLException e) {
			throw new DalException(e.getMessage());
		}
    }
    
    @Override
    public List<Task> selectAll() throws DalException, ClassNotFoundException {
        List<Task> taskList = new ArrayList<>();
        
        try (Connection con = ConnectionProvider.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(SELECT);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
				int idTask = rs.getInt("idTask");
                String label = rs.getString("label");
                LocalDate dtStart = rs.getDate("dtStart").toLocalDate();
                LocalDate dtEnd = rs.getDate("dtEnd").toLocalDate();
                LocalTime hStart = rs.getTime("hStart").toLocalTime();
                LocalTime hEnd = rs.getTime("hEnd").toLocalTime();
                Integer priority = rs.getInt("priority");
                boolean isDone = rs.getBoolean("isDone");

                Task task = new Task(idTask, label, dtStart, dtEnd, hStart, hEnd, priority, isDone);
                taskList.add(task);
            }
        } catch (SQLException e) {
        	throw new DalException(e.getMessage());
        }
        return taskList;
    }
    
    public List<Task> selectAllNotDoneOrderedByPriority() throws DalException, ClassNotFoundException {
        List<Task> taskList = new ArrayList<>();
        
        try (Connection con = ConnectionProvider.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(SELECT_BY_NOT_DONE_ORDER_PRIORITY);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
				int idTask = rs.getInt("idTask");
                String label = rs.getString("label");
                LocalDate dtStart = rs.getDate("dtStart").toLocalDate();
                LocalDate dtEnd = rs.getDate("dtEnd").toLocalDate();
                LocalTime hStart = rs.getTime("hStart").toLocalTime();
                LocalTime hEnd = rs.getTime("hEnd").toLocalTime();
                Integer priority = rs.getInt("priority");
                boolean isDone = rs.getBoolean("isDone");

                Task task = new Task(idTask, label, dtStart, dtEnd, hStart, hEnd, priority, isDone);
                taskList.add(task);
            }
        } catch (SQLException e) {
        	throw new DalException(e.getMessage());
        }
        return taskList;
    }
}
