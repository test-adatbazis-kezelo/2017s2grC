package ro.msg.edu.business.user.boundary;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import ro.msg.edu.business.AbstractIntegrationTest;
import ro.msg.edu.business.common.exception.TechnicalException;
import ro.msg.edu.business.user.dto.UserDTO;

public class UserFacadeTest extends AbstractIntegrationTest {

	@EJB
	private UserFacade userFacade;

	@Test
	public void createUser_succesfull() throws TechnicalException {
		UserDTO testUser = new UserDTO();
		testUser.setFirstname("Will");
		testUser.setLastname("Smith");
		testUser.setEmail("will_smith@msggroup.com");
		testUser.setPassword("1234");
		testUser.setPhoneNumber("+4074567892");
		testUser.setUsername("SmithW");

		List<String> nameRoles = new ArrayList<String>();
		nameRoles.add("ADMINISTRATOR");
		UserDTO createdUser = userFacade.createUser(testUser, nameRoles);

		Assert.assertNotNull("The newly persisted user should have an id!", createdUser.getId());
	}

	@Test
	public void createUser_ActiveByDefault() throws TechnicalException {
		UserDTO testUser = new UserDTO();
		testUser.setFirstname("William");
		testUser.setLastname("Samuel");
		testUser.setEmail("will_samuel@msggroup.com");
		testUser.setPassword("12345");
		testUser.setUsername("SamueW");
		testUser.setPhoneNumber("+4074567892");
		List<String> nameRoles = new ArrayList<String>();
		nameRoles.add("ADMINISTRATOR");
		UserDTO createdUser = userFacade.createUser(testUser, nameRoles);

		Assert.assertTrue("The newly persisted user should be active!", createdUser.isActive());
	}

}
