////////////////////////////////////////////////////////////////////
// [ALESSANDRO] [CANEL] [1204681]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;
import it.unipd.tos.business.Listino;
import it.unipd.tos.model.*;
import it.unipd.tos.model.MenuItem.items;
import it.unipd.tos.business.exception.TakeAwayBillException;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Before;
import org.junit.Rule;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ListinoTest {
    //il setup before prevede che io faccia un listino finto e poi che provi la somma (o totale)
    
    private User user;
    private Listino listino;
    private ArrayList<MenuItem> ordinazioni;
    private ArrayList<Gift> regali;
    @Before
    public void init() {
        user = new User("Alex", "Bello", 18);
        listino = new Listino();
        ordinazioni = new ArrayList<MenuItem>();
        
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
    }  
    
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    
    //vediamo se la somma è corretta, cambia leggermente per lo sconto al gelato meno costoso
    @Test
    public void testSomma() throws TakeAwayBillException {
        assertEquals(25.50, listino.getOrderPrice(ordinazioni, user), 0.00);
    }
    //Sconto solo sul 50%
    @Test
    public void testSconto50() throws TakeAwayBillException {
        ordinazioni.clear();
        ordinazioni.add(new MenuItem("Coppa1", items.gelato, 3));
        ordinazioni.add(new MenuItem("Coppa2", items.gelato, 3));
        ordinazioni.add(new MenuItem("Coppa3", items.gelato, 3));
        ordinazioni.add(new MenuItem("Coppa4", items.gelato, 3));
        ordinazioni.add(new MenuItem("Coppa5", items.gelato, 2));

        assertEquals(13, listino.getOrderPrice(ordinazioni, user), 0.00);
    }  
    
    //Sconto solo sul 10%
    @Test
    public void testSconto10() throws TakeAwayBillException {
        ordinazioni.clear();
        ordinazioni.add(new MenuItem("ElisirOro", items.gelato, 30));
        ordinazioni.add(new MenuItem("ElisirDiamante", items.gelato, 30));

        assertEquals(54, listino.getOrderPrice(ordinazioni, user), 0.00);
    }  
    
    //Sconto solo su entrambi%
    @Test
    public void testScontoEntrambi() throws TakeAwayBillException {
        ordinazioni.clear();
        ordinazioni.add(new MenuItem("ElisirOro", items.gelato, 30));
        ordinazioni.add(new MenuItem("ElisirDiamante", items.gelato, 30));
        ordinazioni.add(new MenuItem("Coppa1", items.gelato, 10));
        ordinazioni.add(new MenuItem("Coppa2", items.gelato, 10));
        ordinazioni.add(new MenuItem("Coppa5", items.gelato, 10));

        assertEquals(76.5, listino.getOrderPrice(ordinazioni, user), 0.00);
    }  
    
    //test per +30
    @Test(expected=TakeAwayBillException.class)
    public void testTroppiElementi() throws TakeAwayBillException {
        for(int i=0; i<50; i++) {
            ordinazioni.add(new MenuItem("ElisirOro", items.gelato, 30));
        }
        
        listino.getOrderPrice(ordinazioni, user);
     }
    //test per <10€
    @Test
    public void testCommissione() throws TakeAwayBillException {
        ordinazioni.clear();
        ordinazioni.add(new MenuItem("Coppa1", items.gelato, 3));
        ordinazioni.add(new MenuItem("Coppa2", items.gelato, 3));
        assertEquals(6.5, listino.getOrderPrice(ordinazioni, user), 0.00);
    }

    //test sia NUMERO vittorie ma ache che torni true
    @Test
    public void testRegalo() throws TakeAwayBillException{
        
        user = new User("Alex", "Bello", 18);
        ordinazioni = new ArrayList<MenuItem>();
        LocalTime time = LocalTime.of(18, 15);
        regali = new ArrayList <Gift>();
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
        
        
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        
        assertEquals(0, listino.Regali(regali));
        
    }
    
    //test sia NUMERO vittorie ma ache che torni true
    @Test
    public void testRegalo10() throws TakeAwayBillException{
        
        user = new User("Alex", "Bello", 18);
        ordinazioni = new ArrayList<MenuItem>();
        LocalTime time = LocalTime.of(18, 15);
        regali = new ArrayList <Gift>();
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
        
        
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
                

        assertEquals(10, listino.Regali(regali));
        
        //testo inoltre che si ricordi le vittorie
        int vittorie = 0;
        for(int i=0; i<regali.size(); i++) {
            if(regali.get(i).getWinner()) {
                vittorie++;
            }
        }
        
        assertEquals(10, vittorie);
    }
    
    //mettiamo il tempo errato e notiamo che torna zero cvd
    @Test
    public void testWrongTime() throws TakeAwayBillException{
        
        user = new User("Alex", "Bello", 18);
        ordinazioni = new ArrayList<MenuItem>();
        LocalTime time = LocalTime.of(15, 15);
        regali = new ArrayList <Gift>();
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
        
        
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
        regali.add(new Gift(ordinazioni, new User("Nome", "Cognome", 12), time));
                

        assertEquals(0, listino.Regali(regali));
        
        //testo inoltre che si ricordi le vittorie
        int vittorie = 0;
        for(int i=0; i<regali.size(); i++) {
            if(regali.get(i).getWinner()) {
                vittorie++;
            }
        }
        
        assertEquals(0, vittorie);
    }
    
}
