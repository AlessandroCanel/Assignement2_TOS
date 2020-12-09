////////////////////////////////////////////////////////////////////
// [ALESSANDRO] [CANEL] [1204681]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import it.unipd.tos.business.Listino;
import it.unipd.tos.model.*;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.unipd.tos.model.MenuItem.items;

public class GiftTest {
    private Gift gift;
    private User user;
    private List<MenuItem> ordinazioni;
    private LocalTime time;

    @Before
    public void init() {
        user = new User("Alex", "Bello", 18);
        ordinazioni = new ArrayList<MenuItem>();
        time = LocalTime.of(15, 15);
        //Ora ordini a caso per simulare ordinazioni(Lista)
        
        ordinazioni.add(new MenuItem("Aceto", items.bevanda, 2.00));
        ordinazioni.add(new MenuItem("Propano", items.bevanda, 5.00));
        ordinazioni.add(new MenuItem("PuffoA", items.gelato, 3.00));
        ordinazioni.add(new MenuItem("PuffoB", items.gelato, 3.00));
        ordinazioni.add(new MenuItem("PuffoC", items.gelato, 3.00));
        ordinazioni.add(new MenuItem("PuffoD", items.gelato, 3.00));
        ordinazioni.add(new MenuItem("PuffoD", items.gelato, 2.00));
        ordinazioni.add(new MenuItem("PuffoE", items.gelato, 1.00));
        ordinazioni.add(new MenuItem("Pannacotta", items.budino, 4.00));
        
        gift = new Gift(ordinazioni, user, time);
    }  
    
    @Test
    public void testTime() {
        assertEquals(LocalTime.of(15, 15), gift.getTime());
    }
    
    @Test
    public void testGetUser() {
        assertEquals(user, gift.getUser());
    }
    
    @Test
    public void testOrdinazioni() {
        assertEquals(ordinazioni , gift.getOrder());
    }
}
