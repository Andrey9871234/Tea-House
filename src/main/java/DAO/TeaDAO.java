package DAO;

import model.Tea;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TeaDAO {
    public List<Tea> getAllTeas() {
        List<Tea> teas = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM tea")) {

            while (rs.next()) {
                Tea tea = new Tea();
                tea.setId(rs.getLong("id"));
                tea.setName(rs.getString("name"));
                tea.setDescription(rs.getString("description"));
                tea.setPrice(rs.getDouble("price"));
                teas.add(tea);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teas;
    }

    public Tea getTeaById(Long id) {
        Tea tea = null;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tea WHERE id = ?")) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tea = new Tea();
                tea.setId(rs.getLong("id"));
                tea.setName(rs.getString("name"));
                tea.setDescription(rs.getString("description"));
                tea.setPrice(rs.getDouble("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tea;
    }

    public void addTea(Tea tea) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO tea (name, description, price) VALUES (?, ?, ?)")) {

            stmt.setString(1, tea.getName());
            stmt.setString(2, tea.getDescription());
            stmt.setDouble(3, tea.getPrice());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTea(Tea tea) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             PreparedStatement stmt = conn.prepareStatement("UPDATE tea SET name = ?, description = ?, price = ? WHERE id = ?")) {

            stmt.setString(1, tea.getName());
            stmt.setString(2, tea.getDescription());
            stmt.setDouble(3, tea.getPrice());
            stmt.setLong(4, tea.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTea(Long id) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM tea WHERE id = ?")) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
