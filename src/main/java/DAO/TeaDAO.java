package DAO;

import models.Tea;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TeaDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private String jdbcUsername = "root";
    private String jdbcPassword = "test";

    private static final String INSERT_TEA_SQL = "INSERT INTO tea" + "  (name, description, price) VALUES " +
            " (?, ?, ?);";

        private static final String SELECT_TEA_BY_ID = "select id, name,  description, price from tea where id =?";
        private static final String SELECT_ALL_TEAS = "select * from tea";
        private static final String DELETE_TEA_SQL = "delete from tea where id = ?;";
        private static final String UPDATE_TEA_SQL = "update tea set name = ?,description= ?, price =? where id = ?;";

    
    public TeaDAO() {}
    
	protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
	
    public List<Tea> getAllTeas() {
        List<Tea> teas = new ArrayList<>();
        try (Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TEAS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Double price = rs.getDouble("price");
                teas.add(new Tea(id, name, description, price));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return teas;
    }

    public Tea getTeaById(Long id) {
        Tea tea = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TEA_BY_ID);) {
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                Double price = rs.getDouble("price");
                tea = new Tea(id, name, description, price);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return tea;
    }

    public void addTea(Tea tea) {
    	System.out.println(INSERT_TEA_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEA_SQL)) {
            preparedStatement.setString(1, tea.getName());
            preparedStatement.setString(2, tea.getDescription());
            preparedStatement.setDouble(3, tea.getPrice());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public boolean updateTea(Tea tea) throws SQLException {
    	boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_TEA_SQL);) {
            statement.setString(1, tea.getName());
            statement.setString(2, tea.getDescription());
            statement.setDouble(3, tea.getPrice());
            statement.setLong(4, tea.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteTea(Long id) throws SQLException {
    	boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_TEA_SQL);) {
            statement.setLong(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
