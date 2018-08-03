package com.app.SpringBootProject.dao;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.app.SpringBootProject.bean.Guest;


//@RunWith(SpringJUnit4ClassRunner.class)
public class GuestDaoImplTest {
	
	//private MockMvc mvc;
	
	//@InjectMocks
	GuestDaoImpl guestDaoImpl = mock(GuestDaoImpl.class);
	
	//GuestDaoImpl im=mock.create(GuestDaoImpl.class);
	

	/*@Test
	public void testRegisterGuest() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateGuest() {
		fail("Not yet implemented");
	}
*/
	@Test
	public void testGetGuest() {
		Guest g=new Guest();
		g.setEmail("a");
		g.setFirstName("a");
		g.setLastName("a");
		g.setAddress("a");
		g.setPhone("a");
		g.setguestId(1);
		
       Guest testObj=guestDaoImpl.registerGuest(g);
	assertEquals("a", testObj.getEmail());
	
		
	
	}

	
	
	
	
	
}
