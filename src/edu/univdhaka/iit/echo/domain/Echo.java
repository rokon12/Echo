package edu.univdhaka.iit.echo.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

public class Echo extends PersistentObject implements Serializable {

	private int id;
	private int version;

	private String echo;
	private UserAccount postedBy;
	private IssueCategory issueCategory;
	private Set<Tag> tags;
	private Set<Photo> photos;
	private String address;
	private Date timeStamp;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public String getEcho() {
		return echo;
	}


	public void setEcho(String echo) {
		this.echo = echo;
	}


	public UserAccount getPostedBy() {
		return postedBy;
	}


	public void setPostedBy(UserAccount postedBy) {
		this.postedBy = postedBy;
	}


	public IssueCategory getIssueCategory() {
		return issueCategory;
	}


	public void setIssueCategory(IssueCategory issueCategory) {
		this.issueCategory = issueCategory;
	}


	public Set<Tag> getTags() {
		return tags;
	}


	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}


	public Set<Photo> getPhotos() {
		return photos;
	}


	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getAccuracy() {
		return accuracy;
	}


	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}


	public double getAltitude() {
		return altitude;
	}


	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}


	public String getGeoLocation() {
		return geoLocation;
	}


	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}


	public Date getGeoTimeStamp() {
		return geoTimeStamp;
	}


	public void setGeoTimeStamp(Date geoTimeStamp) {
		this.geoTimeStamp = geoTimeStamp;
	}


	public boolean isAnonymous() {
		return anonymous;
	}


	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}


	// GeoData
	private double longitude;
	private double latitude;
	private double accuracy;
	private double altitude;
	private String geoLocation;
	private Date geoTimeStamp;

	private boolean anonymous;


	@Override
	public String toString() {
		return "Echo{" + "id=" + id + ", postedText='" + echo + '\''
				+ ", timestamp=" + geoTimeStamp + ", postedBy=" + postedBy
				+ '}';
	}
}
