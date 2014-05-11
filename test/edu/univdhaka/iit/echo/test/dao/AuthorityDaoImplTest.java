package edu.univdhaka.iit.echo.test.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.univdhaka.iit.echo.dao.AuthorityDao;
import edu.univdhaka.iit.echo.dao.AuthorityDaoImpl;
import edu.univdhaka.iit.echo.domain.Authority;

public class AuthorityDaoImplTest {

	private static final int ID = 1;
	private static final int VERSION = 0;
	private static final String NAME = "something";

	private AuthorityDao authorityDao;

	@Before
	public void setUp() {
		authorityDao = new AuthorityDaoImpl();
	}

	@Test
	public void testInsert() {
		Authority authority = new Authority();

		authority.setVersion(VERSION);
		authority.setName(NAME);

		authorityDao.insert(authority);

		// Check By Asserting
		Authority newAuthority = authorityDao.select(ID);

		Assert.assertNotNull(newAuthority);
		Assert.assertEquals(ID, newAuthority.getId());
		Assert.assertEquals(VERSION, newAuthority.getVersion());
		Assert.assertEquals(NAME, newAuthority.getName());
	}

	@Test
	public void testDelete() {
		authorityDao.delete(ID);

		// Check By Asserting
		Authority newAuthority = authorityDao.select(ID);
		Assert.assertNull(newAuthority);
	}

	@Test
	public void testUpdate() {
		Authority authority = new Authority();

		authority.setId(ID);
		authority.setVersion(VERSION);
		authority.setName(NAME);

		authorityDao.update(authority, ID);

		// Check By Asserting
		Authority newAuthority = authorityDao.select(ID);

		Assert.assertNotNull(newAuthority);
		Assert.assertEquals(ID, newAuthority.getId());
		Assert.assertEquals(VERSION, newAuthority.getVersion());
		Assert.assertEquals(NAME, newAuthority.getName());
	}

	@Test
	public void testSelect() {
		// Check By Asserting
		Authority newAuthority = authorityDao.select(ID);

		Assert.assertNotNull(newAuthority);
		Assert.assertEquals(ID, newAuthority.getId());
		Assert.assertEquals(VERSION, newAuthority.getVersion());
		Assert.assertEquals(NAME, newAuthority.getName());
	}

	@Test
	public void testGetAllAuthotrityInfo() {
		authorityDao.getAllAuthorityInfo();
	}

}
