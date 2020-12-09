////////////////////////////////////////////////////////////////////
// [ALESSANDRO] [CANEL] [1204681]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import it.unipd.tos.model.User;
import org.junit.Before;

public class UserTest {
	User persona;
	
	//come per il test MenuItemTest creiamo Alex Bello che ha 18 anni
    @Before
    public void setup()
    {
           persona = new User("Alex", "Bello", 18);
    }
	
    //testiamo se la età è corretta
	@Test
    public void getAgeTest()
    {
             assertEquals(18, persona.getAge(), 0.0);
    }
	
	//testiamo se Torna nome giusto
	@Test
    public void getNameTest()
    {
             assertEquals("Alex", persona.getName());
    }
	//testiamo se Torna snome giusto
    @Test
    public void getSnameTest()
    {
             assertEquals("Bello", persona.getSname());
    }

    //e ora quelli che mi aspetto falliranno
    //non ha età
    @Test ( expected = IllegalArgumentException.class )
    public void testUserNotBorn() {
        new User("Alex", "Bello", 0);
    }
    //nome e snome vuoti
    @Test ( expected = IllegalArgumentException.class )
    public void testUserSnameEmpty() {
        new User("Alex", "", 18);
    }
    @Test ( expected = IllegalArgumentException.class )
    public void testUserNameEmpty() {
        new User("", "Bello", 18);
    }

}
