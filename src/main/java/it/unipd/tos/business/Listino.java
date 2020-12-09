////////////////////////////////////////////////////////////////////
// [ALESSANDRO] [CANEL] [1204681]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.Gift;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;


public class Listino implements TakeAwayBill {

    public double getOrderPrice(List<MenuItem> items, User User) throws TakeAwayBillException {

        if(items.size() >= 30) {
            
            throw new TakeAwayBillException("Troppi ordini");
        }
        
        //salviamo sempre il totale nel listino
        double somma = 0;
        int gelati = 0;
        int totGelatiBudini = 0;
        double min = 1000;
        
        //contiamo i gelati e prendiamo il min
        for (MenuItem menuItem : items) {
            if (menuItem.getType().equals(MenuItem.items.gelato)) {
                gelati++;
                totGelatiBudini += menuItem.getPrice();
                if (menuItem.getPrice() < min) {
                    min = menuItem.getPrice();
                }
            }
            if (menuItem.getType().equals(MenuItem.items.budino)) {
                totGelatiBudini += menuItem.getPrice();
            }
        }
        
        //abbiamo la lista, ora la scorriamo iterativamente per somma
        for (MenuItem menuItem : items) { 
            somma += menuItem.getPrice();
        }
        //Se ci sono piu' di 5 gelati si toglie min/2
        if(gelati >= 5) {
            somma -= min/2;
        }
        //Se  l’importo  totale  delle  ordinazioni  (Gelati  e  Budini)  supera  i  50  euro  viene  fatto  il  10%  disconto;
        if(totGelatiBudini > 50) {
            somma = somma * 0.9;
        }
        //commissione aggiuntiva da 0.50€ se ordine < 10€ 
        if(somma < 10){
            somma += 0.5;
        }
        
        return somma;
    }

    
    //implementiamo ora i regali
    public int Regali(List <Gift> regali) {
        //lista di quelli che sono stati scelti
        ArrayList<Gift> scelti = new ArrayList<Gift>();
        Boolean trovato = true;
        for (Gift list : regali) {
            //minori di 18
            if(list.getUser().getAge() <= 18) {
                //fatti tra le 18 e 19
                if (list.getTime().isBefore(LocalTime.of(19, 00)) && list.getTime().isAfter(LocalTime.of(18, 00))) {
                    for (Gift prescelto : scelti) {
                        if (prescelto.getUser().equals(list.getUser())) {
                            trovato = false;
                        }
                    } 
                    if (trovato) {
                        scelti.add(list);
                    }
                }
            }
        }
        
        //regalo
        int numeroRegali = 0;
        if (scelti.size() > 9) {
            
            Random rand = new Random();

            for (int i = 0; i < 10; i++) {
                numeroRegali += 1;
                //viene estratto un numero dalla size di scelti
                int numero = rand.nextInt(scelti.size());
                Gift vincitore = scelti.get(numero);
                //ora dobbiamo ricordare chi vince
                vincitore.setGiveAway(true);
                scelti.remove(vincitore);
            }
        }     
        return numeroRegali;
    }
    
}
