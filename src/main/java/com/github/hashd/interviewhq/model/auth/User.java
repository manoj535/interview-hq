package com.github.hashd.interviewhq.model.auth;

import com.github.hashd.interviewhq.model.enums.Gender;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;
import java.util.List;

/**
 * Created by kd on 31/5/15.
 */
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}), @UniqueConstraint(columnNames = {"email"})})
public class User {
  private Long    id;
  private String  username;
  private String  fullName;
  private char[]  password;
  private Gender  gender;
  private Date    birthDate;
  private String  emailAddress;
  private String  mobileNumber;
  private boolean enabled;

  private List<UserRole> userRoles;

  public User() {
  }

  public User(String username, String password, String fullName, Gender gender, Date birthDate, String emailAddress, String mobileNumber, boolean enabled) {
    this.username = username;
    this.fullName = fullName;
    this.gender = gender;
    this.birthDate = birthDate;
    this.emailAddress = emailAddress;
    this.mobileNumber = mobileNumber;
    this.password = password.toCharArray();
    this.enabled = enabled;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Column(name = "full_name")
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "enum('MALE', 'FEMALE')")
  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  @Column(name = "birth_date")
  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  @Column(name = "email")
  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  @Column(name = "mobile")
  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  @Column(name = "password")
  public char[] getPassword() {
    return password;
  }

  public void setPassword(char[] password) {
    this.password = password;
  }

  @Column(name = "enabled")
  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public List<UserRole> getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(List<UserRole> userRoles) {
    this.userRoles = userRoles;
  }
}
