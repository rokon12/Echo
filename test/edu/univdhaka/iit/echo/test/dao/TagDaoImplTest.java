package edu.univdhaka.iit.echo.test.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.univdhaka.iit.echo.dao.TagDao;
import edu.univdhaka.iit.echo.dao.TagDaoImpl;
import edu.univdhaka.iit.echo.domain.Tag;

public class TagDaoImplTest {

	private static final int ID = 1;
	private static final int VERSION = 0;
	private static final String TITLE = "something";

	private TagDao tagDao;

	@Before
	public void setUp() {
		tagDao = new TagDaoImpl();
	}

	@Test
	public void testInsert() {
		Tag tag = new Tag();

		tag.setVersion(VERSION);
		tag.setTitle(TITLE);
		
		tagDao.insert(tag);

		// Check by asserting
		Tag newTag = tagDao.select(ID);

		Assert.assertNotNull(newTag);
		Assert.assertEquals(ID, newTag.getId());
		Assert.assertEquals(VERSION, newTag.getVersion());
		Assert.assertEquals(TITLE, newTag.getTitle());
	}

	@Test
	public void testDelete() {
		tagDao.delete(ID);

		// Check by asserting
		Tag newTag = tagDao.select(ID);

		Assert.assertNull(newTag);
	}

	@Test
	public void testUpdate() {
		Tag tag = new Tag();

		tag.setVersion(VERSION);
		tag.setTitle(TITLE);

		tagDao.update(tag, ID);

		// Check by asserting
		Tag newTag = tagDao.select(ID);

		Assert.assertNotNull(newTag);
		Assert.assertEquals(ID, newTag.getId());
		Assert.assertEquals(VERSION, newTag.getVersion());
		Assert.assertEquals(TITLE, newTag.getTitle());
	}

	@Test
	public void testSelect() {
		Tag newTag = tagDao.select(ID);

		Assert.assertNotNull(newTag);
		Assert.assertEquals(ID, newTag.getId());
		Assert.assertEquals(VERSION, newTag.getVersion());
		Assert.assertEquals(TITLE, newTag.getTitle());
	}

	@Test
	public void testGetAllEcho() {
		tagDao.getAllTagInfo();
	}

}
