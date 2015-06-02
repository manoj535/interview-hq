package com.github.hashd.interviewhq.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by kd on 2/6/15.
 */
@Entity
@Table(name = "user_roles")
public class UserRole {
  private Long   id;
  private User   user;
  private String role;

  public UserRole() {
  }

  public UserRole(User user, String role) {
    this.user = user;
    this.role = role;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_role_id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @JsonIgnore
  @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Column(name = "role")
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}
