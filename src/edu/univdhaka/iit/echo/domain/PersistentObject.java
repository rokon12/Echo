package edu.univdhaka.iit.echo.domain;

import java.sql.Date;

// Abstract Class for General Information
public abstract class PersistentObject {
    private Date createdDate;
    private Date lastModifiedDate;
	private UserAccount lastModifiedBy;
    private UserAccount createdBy;
    
    public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public UserAccount getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(UserAccount lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public UserAccount getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(UserAccount createdBy) {
		this.createdBy = createdBy;
	}  
}
