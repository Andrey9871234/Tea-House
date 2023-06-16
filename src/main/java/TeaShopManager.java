import DAO.TeaDAO;
import model.Tea;

import java.util.List;

public class TeaShopManager {

    private TeaDAO teaDAO;

    public TeaShopManager() {
        this.teaDAO = new TeaDAO(); // Instantiate TeaDAO
    }

    public void initialize() {
        // Perform initialization tasks, if required
    }

    public void run() {
        // Main logic of the tea shop application
        // You can implement your own menu or user interface for interacting with the tea shop

        // Example: Print the list of teas using the TeaDAO
        List<Tea> teas = teaDAO.getAllTeas();
        System.out.println("Tea Shop Menu:");
        for (Tea tea : teas) {
            System.out.println(tea.getId() + ". " + tea.getName() + ": " + tea.getDescription());
        }
    }

    // Other methods for managing tea shop functionality

    public void addTea(Tea tea) {
        teaDAO.addTea(tea);
    }

    public void updateTea(Tea tea) {
        teaDAO.updateTea(tea);
    }

    public void deleteTea(long teaId) {
        teaDAO.deleteTea(teaId);
    }

    public Tea getTeaById(long teaId) {
        return teaDAO.getTeaById(teaId);
    }
}