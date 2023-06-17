
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDAO {
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM user")) {

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAdmin(rs.getBoolean("is_admin"));
                users.add(user);
            }

        } catch (SQLException e) {
        }

        return users;
    }

    public User getUserById(Long id) {
        User user = null;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE id = ?")) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAdmin(rs.getBoolean("is_admin"));
            }

        } catch (SQLException e) {
        }

        return user;
    }

    public void addUser(User user) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO user (username, email, password, is_admin) VALUES (?, ?, ?, ?)")) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setBoolean(4, user.isAdmin());
            stmt.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public void updateUser(User user) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             PreparedStatement stmt = conn.prepareStatement("UPDATE user SET username = ?, email = ?, password = ?, is_admin = ? WHERE id = ?")) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setBoolean(4, user.isAdmin());
            stmt.setLong(5, user.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public void deleteUser(Long id) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM user WHERE id = ?")) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
        }
    }
}
