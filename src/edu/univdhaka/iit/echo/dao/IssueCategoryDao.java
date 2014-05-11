package edu.univdhaka.iit.echo.dao;

import java.util.List;

import edu.univdhaka.iit.echo.domain.IssueCategory;

public interface IssueCategoryDao {
	
	public void insert(IssueCategory category);

	public List<IssueCategory> getAllIssueCategoryInfo();

	public void delete(int id);

	public void update(IssueCategory category, int id);

	public IssueCategory select(int id);
	
}
