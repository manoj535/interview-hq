package com.github.hashd.interviewhq.model;

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
import java.util.Date;

/**
 * Created by kd on 2/6/15.
 */
@Entity
@Table(name = "comments")
public class Comment {
  private Long     id;
  private String   comment;
  private User     postedBy;
  private Question question;
  private Date     createdOn;
  private Date     lastModifiedOn;

  public Comment() {
  }

  public Comment(Question question, String comment) {
    this.comment = comment;
    this.question = question;
  }

  public Comment(Question question, String comment, User postedBy) {
    this.comment = comment;
    this.postedBy = postedBy;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "comment_id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "comment", length = 65536)
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Column(name = "creation_date")
  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  @Column(name = "last_modified_date")
  public Date getLastModifiedOn() {
    return lastModifiedOn;
  }

  public void setLastModifiedOn(Date lastModifiedOn) {
    this.lastModifiedOn = lastModifiedOn;
  }

  @JsonIgnore
  @ManyToOne(targetEntity = Question.class, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "question_id")
  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }
}
