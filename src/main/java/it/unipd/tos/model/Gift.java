////////////////////////////////////////////////////////////////////
// [ALESSANDRO] [CANEL] [1204681]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import java.time.LocalTime;
import java.util.List;

import it.unipd.tos.model.MenuItem.items;
import it.unipd.tos.model.User;

public class Gift {
    private List<MenuItem> order;
    private User user;
    private LocalTime orderTime;
    private boolean victory = false;

    public Gift(List<MenuItem> order, User user, LocalTime time) {
        this.order = order;
        this.user = user;
        this.orderTime = time;
    }
    
    //per ricordarci chi vince basterà chiamare victory
    public boolean setGiveAway(boolean ricorda) {
        victory = ricorda;
        return ricorda;
    }

    public LocalTime getTime() {
        return orderTime;
    }

    public User getUser() {
        return user;
    }

    public List<MenuItem> getOrder() {
        return order;
    }
    
    public boolean getWinner() {
        return victory;
    }

}
