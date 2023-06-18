package models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;
    private List<Tea> teas;
    private User user;
    private double totalPrice;
    
    
    public Order(Long id, User user) {
        this.id = id;
        this.teas = new ArrayList<>();
        this.user = user;
       
        this.totalPrice = 0.0;
    }

    public Order() {
         }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public List<Tea> getTeas() {
        return teas;
    }
    
    public void setTeas(List<Tea> teas) {
        this.teas = teas;
        updateTotalPrice();
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
     
    public double getTotalPrice() {
        return totalPrice;
    }
    
    
    public void addTea(Tea tea) {
        teas.add(tea);
        updateTotalPrice();
    }
    
   
    public void removeTea(Tea tea) {
        teas.remove(tea);
        updateTotalPrice();
    }
    
    
    private void updateTotalPrice() {
        totalPrice = 0.0;
        for (Tea tea : teas) {
            totalPrice += tea.getPrice();
        }
    }

    public void setTotalPrice(double aDouble) {
      totalPrice=aDouble;  }
}

