package com.github.hashd.interviewhq.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by kd on 31/5/15.
 */
@Entity
@Table(name = "questions")
public class Question {
  private Long   id;
  private String content;
  private Date   createdOn;
  private Date   lastModifiedOn;

  private Set<QuestionTag> questionTags;

  public Question() {
  }

  public Question(String content, Date createdOn, Date lastModifiedOn) {
    this.content = content;
    this.createdOn = createdOn;
    this.lastModifiedOn = lastModifiedOn;
  }

  public Question(Long id, String content, Date createdOn, Date lastModifiedOn) {
    this.id = id;
    this.content = content;
    this.createdOn = createdOn;
    this.lastModifiedOn = lastModifiedOn;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "question_id")
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

  @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
  public Set<QuestionTag> getQuestionTags() {
    return questionTags;
  }

  public void setQuestionTags(Set<QuestionTag> questionTags) {
    this.questionTags = questionTags;
  }

  @Override
  public String toString() {
    return "Question{" +
      "id=" + id +
      ", content='" + content + '\'' +
      ", createdOn=" + createdOn +
      ", lastModifiedOn=" + lastModifiedOn +
      ", questionTags=" + questionTags +
      '}';
  }
}
