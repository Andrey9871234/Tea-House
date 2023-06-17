
import DAO.OrderDAO;
import DAO.UserDAO;
import java.util.List;
import model.Order;
import model.User;

public class Main {
    public static void main(String[] args) {
        TeaShopManager teaShopManager = new TeaShopManager();
        teaShopManager.initialize(); // Initialize the tea shop

        // Run the main logic of the tea shop application
        teaShopManager.run();
         testUserDAO();
        testOrderDAO();
    }
 public static void testUserDAO() {
        UserDAO userDAO = new UserDAO();

        // Test getAllUsers()
        List<User> users = userDAO.getAllUsers();
        System.out.println("Users:");
        for (User user : users) {
            System.out.println(user);
        }

        // Test getUserById()
        Long userId = 1L;
        User user = userDAO.getUserById(userId);
        System.out.println("User with ID " + userId + ":");
        System.out.println(user);

        // Test addUser()
        User newUser = new User();
        newUser.setUsername("JohnDoe");
        newUser.setEmail("john.doe@example.com");
        newUser.setPassword("password");
        newUser.setAdmin(false);
        userDAO.addUser(newUser);
        System.out.println("Added user: " + newUser);

        // Test updateUser()
        newUser.setEmail("john.doe.updated@example.com");
        userDAO.updateUser(newUser);
        System.out.println("Updated user: " + newUser);

        // Test deleteUser()
        Long deleteUserById = 2L; // Assuming there is a user with ID 2 to delete
        userDAO.deleteUser(deleteUserById);
        System.out.println("Deleted user with ID " + deleteUserById);
    }

    public static void testOrderDAO() {
        OrderDAO orderDAO = new OrderDAO();

        // Test getAllOrders()
        List<Order> orders = orderDAO.getAllOrders();
        System.out.println("Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Test getOrderById()
        Long orderId = 1L;
        Order order = orderDAO.getOrderById(orderId);
        System.out.println("Order with ID " + orderId + ":");
        System.out.println(order);

        // Test addOrder()
        Order newOrder = new Order();
        // Set the order details
        orderDAO.addOrder(newOrder);
        System.out.println("Added order: " + newOrder);

        // Test updateOrder()
        // Update the order details
        orderDAO.updateOrder(newOrder);
        System.out.println("Updated order: " + newOrder);

        // Test deleteOrder()
        Long deleteOrderId = 2L; // Assuming there is an order with ID 2 to delete
        orderDAO.deleteOrder(deleteOrderId);
        System.out.println("Deleted order with ID " + deleteOrderId);
    }
}