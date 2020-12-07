////////////////////////////////////////////////////////////////////
// [ALESSANDRO] [CANEL] [1204681]
////////////////////////////////////////////////////////////////////

package it.unipd.tos;

import it.unipd.tos.MenuItem;


import static org.junit.Assert.assertEquals;
//import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;


public class MenuItemTest {
	
	MenuItem menu;
	//test basico
	@Before
    public void setup()
    {
           menu = new MenuItem("bingo", MenuItem.items.Budino, 11.00);
    }
	@Test
    public void getPrice()
    {
            assertEquals(11.00, menu.getPrice(), 0.0);
    }
}
