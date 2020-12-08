package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;
import it.unipd.tos.business.Listino;
import it.unipd.tos.model.*;
import it.unipd.tos.model.MenuItem.items;
import it.unipd.tos.business.exception.TakeAwayBillException;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.util.List;

public class ListinoTest {
    //il setup before prevede che io faccia un listino finto e poi che provi la somma (o totale)
    
    private User user;
    private Listino listino;
    private List<MenuItem> ordinazioni;

    @Before
    public void init() {
        user = new User("Alex", "Bello", 18);
        listino = new Listino();
        ordinazioni = new ArrayList<MenuItem>();
        
        //Ora ordini a caso per simulare ordinazioni(Lista)
        
        ordinazioni.add(new MenuItem("Aceto", items.bevanda, 2.00));
        ordinazioni.add(new MenuItem("Propano", items.bevanda, 5.00));
        ordinazioni.add(new MenuItem("Puffo", items.gelato, 3.00));
        ordinazioni.add(new MenuItem("Pannacotta", items.budino, 4.00));
    }  
    
    
    //vediamo se la somma è corretta
    @Test
    public void testSomma() throws TakeAwayBillException {
        assertEquals(14.00, listino.getOrderPrice(ordinazioni, user), 0.00);
    }
}
