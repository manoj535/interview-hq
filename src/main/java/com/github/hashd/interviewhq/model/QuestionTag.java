package com.github.hashd.interviewhq.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by kd on 31/5/15.
 */
@Entity
@Table(name = "question_tags")
public class QuestionTag {
  private Long     id;
  private Question question;
  private Tag      tag;

  public QuestionTag() {
  }

  public QuestionTag(Question question, Tag tag) {
    this.question = question;
    this.tag = tag;
  }

  public QuestionTag(Long id, Question question, Tag tag) {
    this.id = id;
    this.question = question;
    this.tag = tag;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "question_tag_id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  @JsonIgnore
  @ManyToOne(targetEntity = Tag.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "tag_id")
  public Tag getTag() {
    return tag;
  }

  public void setTag(Tag tag) {
    this.tag = tag;
  }

  @Override
  public String toString() {
    return "QuestionTag{" +
      "id=" + id +
      ", tag=" + tag +
      '}';
  }
}
