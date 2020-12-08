////////////////////////////////////////////////////////////////////
// [ALESSANDRO] [CANEL] [1204681]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class Listino implements TakeAwayBill {
    

    public double getOrderPrice(List<MenuItem> itemsOrdered, User User) throws TakeAwayBillException {
        //Se la lista null exception
        if (itemsOrdered == null) {
            throw new TakeAwayBillException("Lista non valida");
        }
        //user come null
        if (User == null) {
            throw new TakeAwayBillException("User non valido");
        }
        //se listino vuoto diventa inutile quindi Exception
        if (itemsOrdered.isEmpty()) {
            throw new TakeAwayBillException("Lista ordini vuota");
        }
        
        //salviamo sempre il totale nel listino
        double somma = 0;
        int gelati = 0;
        
        double min = 1000;
        
        //contiamo i gelati e prendiamo il min
        for (MenuItem menuItem : itemsOrdered) {
            if (menuItem.getType().equals(MenuItem.items.gelato)) {
                gelati++;
                if (menuItem.getPrice() < min) {
                    min = menuItem.getPrice();
                }
            }
        }
        
        //abbiamo la lista, ora la scorriamo iterativamente per somma
        for (MenuItem menuItem : itemsOrdered) { 
            somma += menuItem.getPrice();
        }
        //Se ci sono piu' di 5 gelati si toglie min/2
        if(gelati >= 5) {
            somma -= min/2;
        }
        
        
        return somma;
    }

    
}