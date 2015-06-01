package com.github.hashd.interviewhq.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.hashd.interviewhq.model.Question;
import com.github.hashd.interviewhq.model.QuestionTag;
import com.github.hashd.interviewhq.utils.serializer.JsonDateSerializer;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by kd on 31/5/15.
 */
public class QuestionVO {
  private Long             id;
  private String           question;
  private String           difficulty;
  private Date             createdOn;
  private Date             lastModifiedOn;
  private Set<SimpleTagVO> tags;

  public QuestionVO(Question question) {
    this.id = question.getId();
    this.question = question.getContent();
    this.difficulty = question.getDifficulty().name();
    this.createdOn = question.getCreatedOn();
    this.lastModifiedOn = question.getLastModifiedOn();

    if (question.getQuestionTags() != null) {
      tags = new LinkedHashSet<>(question.getQuestionTags().size());
      for (QuestionTag questionTag : question.getQuestionTags()) {
        tags.add(new SimpleTagVO(questionTag.getTag()));
      }
    }
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public Date getLastModifiedOn() {
    return lastModifiedOn;
  }

  public void setLastModifiedOn(Date lastModifiedOn) {
    this.lastModifiedOn = lastModifiedOn;
  }

  public Set<SimpleTagVO> getTags() {
    return tags;
  }

  public void setTags(Set<SimpleTagVO> tags) {
    this.tags = tags;
  }
}
