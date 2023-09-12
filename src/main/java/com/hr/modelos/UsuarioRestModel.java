package com.hr.modelos;

public class UsuarioRestModel {
  private Integer userId;
  private Integer id;
  private String title;
  private Boolean completed;

  public Integer getUserId() {
    return this.userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Boolean isCompleted() {
    return this.completed;
  }

  public Boolean getCompleted() {
    return this.completed;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  @Override
  public String toString() {
    return "{" +
        " userId='" + getUserId() + "'" +
        ", id='" + getId() + "'" +
        ", title='" + getTitle() + "'" +
        ", completed='" + isCompleted() + "'" +
        "}";
  }

}
