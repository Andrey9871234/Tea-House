/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Order;
import model.Tea;
import model.User;

public class OrderDAO {
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM orders")) {

            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getLong("id"));
                order.setUser(getUserById(rs.getLong("user_id")));
                order.setTeas(getOrderTeas(order.getId()));
                order.setTotalPrice(rs.getDouble("total_price"));
                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public Order getOrderById(Long id) {
        Order order = null;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM orders WHERE id = ?")) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                order = new Order();
                order.setId(rs.getLong("id"));
                order.setUser(getUserById(rs.getLong("user_id")));
                order.setTeas(getOrderTeas(order.getId()));
                order.setTotalPrice(rs.getDouble("total_price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    public void addOrder(Order order) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO orders (user_id, shipping_address, total_price) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, order.getUser().getId());
            stmt.setDouble(3, order.getTotalPrice());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                long orderId = generatedKeys.getLong(1);
                order.setId(orderId);
                insertOrderTeas(orderId, order.getTeas());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrder(Order order) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             PreparedStatement stmt = conn.prepareStatement("UPDATE orders SET user_id = ?, shipping_address = ?, total_price = ? WHERE id = ?")) {

            stmt.setLong(1, order.getUser().getId());
            stmt.setDouble(3, order.getTotalPrice());
            stmt.setLong(4, order.getId());
            stmt.executeUpdate();

            deleteOrderTeas(order.getId());
            insertOrderTeas(order.getId(), order.getTeas());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(Long id) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM orders WHERE id = ?")) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
            deleteOrderTeas(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Tea> getOrderTeas(Long orderId) {
        List<Tea> teas = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             PreparedStatement stmt = conn.prepareStatement("SELECT tea.* FROM tea JOIN order_tea ON tea.id = order_tea.tea_id WHERE order_tea.order_id = ?")) {

            stmt.setLong(1, orderId);
            ResultSet rs = stmt.executeQuery();

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

    private void insertOrderTeas(Long orderId, List<Tea> teas) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO order_tea (order_id, tea_id) VALUES (?, ?)")) {

            for (Tea tea : teas) {
                stmt.setLong(1, orderId);
                stmt.setLong(2, tea.getId());
                stmt.addBatch();
            }

            stmt.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteOrderTeas(Long orderId) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webTech?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "test");
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM order_tea WHERE order_id = ?")) {

            stmt.setLong(1, orderId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User getUserById(Long id) {
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
        e.printStackTrace();
    }

    return user;
}

}
