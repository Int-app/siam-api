package com.bezkoder.spring.restapi.model;

public class Tutorial {
  private long id = 0;

  private String title;

  private String description;

  private boolean published;
  
  private String username;

  public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

private String password;

  private String code;

  public Tutorial() {

  }

  public Tutorial(String title, String description, boolean published) {
    this.title = title;
    this.description = description;
    this.published = published;
  }

  public void setId(long id) {
    this.id = id;
  }
  
  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isPublished() {
    return published;
  }

  public void setPublished(boolean isPublished) {
    this.published = isPublished;
  }

  @Override
  public String toString() {
    return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
  }

}
