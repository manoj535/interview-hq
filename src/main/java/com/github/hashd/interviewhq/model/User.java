package com.github.hashd.interviewhq.model;

import com.github.hashd.interviewhq.model.enums.Gender;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

/**
 * Created by kd on 31/5/15.
 */
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = {"username"})})
public class User {
  private Long   id;
  private String username;
  private String fullName;
  private Gender gender;
  private Date   birthDate;
  private String emailAddress;
  private String mobileNumber;

  public User() {
  }

  public User(String username, String fullName, Gender gender, Date birthDate, String emailAddress, String mobileNumber) {
    this.username = username;
    this.fullName = fullName;
    this.gender = gender;
    this.birthDate = birthDate;
    this.emailAddress = emailAddress;
    this.mobileNumber = mobileNumber;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  public Long getId() {
    return id;
  }

  @Column(name = "username")
  public String getUsername() {
    return username;
  }

  @Column(name = "full_name")
  public String getFullName() {
    return fullName;
  }

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "enum('MALE', 'FEMALE')")
  public Gender getGender() {
    return gender;
  }

  @Column(name = "birth_date")
  public Date getBirthDate() {
    return birthDate;
  }

  @Column(name = "email")
  public String getEmailAddress() {
    return emailAddress;
  }

  @Column(name = "mobile")
  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }
}
