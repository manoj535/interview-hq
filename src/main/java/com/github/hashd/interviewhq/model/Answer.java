package com.github.hashd.interviewhq.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.hashd.interviewhq.model.auth.User;

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

@Entity
@Table(name = "answers")
public class Answer {
  private Long     id;
  private Question question;
  private String   content;
  private User     postedBy;
  private Date     createdOn;
  private Date     lastModifiedOn;

  public Answer() {

  }

  public Answer(Question question, String content) {
    this.setId(id);
    this.setQuestion(question);
    this.setContent(content);
  }

  public Answer(Long id, Question question, String content) {
    this.setId(id);
    this.setQuestion(question);
    this.setContent(content);
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "answer_id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "content", length = 65536)
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @JsonIgnore
  @ManyToOne(targetEntity = Question.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "question_id")
  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
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
}
