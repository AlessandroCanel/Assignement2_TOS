////////////////////////////////////////////////////////////////////
// [ALESSANDRO] [CANEL] [1204681]
////////////////////////////////////////////////////////////////////

package it.unipd.tos;

import it.unipd.tos.User;


import static org.junit.Assert.assertEquals;
//import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;

public class UserTest {
	User persona;
	
    @Before
    public void setup()
    {
           persona = new User("Alex", "Bello", 18, "acx");
    }
	
	@Test
    public void getAgeTest()
    {
             assertEquals(18, persona.getAge());
    }
}
