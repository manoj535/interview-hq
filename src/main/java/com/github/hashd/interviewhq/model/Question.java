package com.github.hashd.interviewhq.model;

import com.github.hashd.interviewhq.model.auth.User;
import com.github.hashd.interviewhq.model.enums.Difficulty;

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
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by kd on 31/5/15.
 */
@Entity
@Table(name = "questions")
public class Question {
  private Long       id;
  private String     content;
  private Difficulty difficulty;
  private User       postedBy;
  private Date       createdOn;
  private Date       lastModifiedOn;

  private Set<QuestionTag> questionTags;
  private List<Answer>     answers;
  private List<Comment>    comments;

  public Question() {
  }

  public Question(String content, Difficulty difficulty) {
    this.content = content;
    this.difficulty = difficulty;
    this.createdOn = new Date();
    this.lastModifiedOn = new Date();
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

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "enum('EASY', 'MEDIUM', 'HARD')")
  public Difficulty getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(Difficulty difficulty) {
    this.difficulty = difficulty;
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

  @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public Set<QuestionTag> getQuestionTags() {
    return questionTags;
  }

  public void setQuestionTags(Set<QuestionTag> questionTags) {
    this.questionTags = questionTags;
  }

  @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public List<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }

  @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
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
