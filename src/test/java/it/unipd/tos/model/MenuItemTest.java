////////////////////////////////////////////////////////////////////
// [ALESSANDRO] [CANEL] [1204681]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;


public class MenuItemTest {
	
	MenuItem menu;
	//prima si fa  il bingo budino item
	@Before
    public void setup()
    {
           menu = new MenuItem("Bingo", MenuItem.items.budino, 11.00);
    }
	//ora i test del prezzo (se Equals torna il prezzo uguale)
	@Test
    public void getPrice()
    {
            assertEquals(11.00, menu.getPrice(), 0.0);
    }
	//Equals torna lo stesso nome?
	@Test
    public void getName()
    {
            assertEquals("Bingo", menu.getName());
    }
	//Equals torna lo stesso tipo?(mettere solo "budino" è erore)
    @Test
    public void getType()
    {
            assertEquals(MenuItem.items.budino, menu.getType());
    }
	
    
 /*   
    //e ora i test che prevedo falliranno

    //Nessun nome dato
    @Test (expected = IllegalArgumentException.class)
    public void getNonameTest() {
        new MenuItem ("", MenuItem.items.gelato, 7.00);
    }
    //Se spazi non va bene
    @Test (expected = IllegalArgumentException.class)
    public void getNoSpacesTest() {
        new MenuItem (" ", MenuItem.items.gelato, 7.00);
    }
    //nessun prezzo dato
    @Test (expected = IllegalArgumentException.class)
    public void getNopriceTest() {
        new MenuItem ("Tuttifrutti", MenuItem.items.gelato, 0.0);
    }
    //nessun tipo dato
    @Test (expected = IllegalArgumentException.class)
    public void getNoitemTest() {
        new MenuItem ("Tuttifrutti", null , 7.00);
    }
*/
}
