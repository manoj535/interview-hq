package com.github.hashd.interviewhq.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.hashd.interviewhq.model.Question;
import com.github.hashd.interviewhq.model.QuestionTag;
import com.github.hashd.interviewhq.model.Tag;
import com.github.hashd.interviewhq.utils.serializer.JsonDateSerializer;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by kd on 31/5/15.
 */
public class TagVO {
  private Long            id;
  private String          tag;
  private String          description;
  private Date            createdOn;
  private Date            lastModifiedOn;
  private Set<QuestionVO> questions;

  public TagVO(Tag tag) {
    this.id = tag.getId();
    this.tag = tag.getTag();
    this.description = tag.getDescription();
    this.createdOn = tag.getCreatedOn();
    this.lastModifiedOn = tag.getLastModifiedOn();

    if (tag.getQuestionTags() != null) {
      this.questions = new LinkedHashSet<>(tag.getQuestionTags().size());
      for (QuestionTag questionTag : tag.getQuestionTags()) {
        this.questions.add(new QuestionVO(questionTag.getQuestion()));
      }
    }
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @JsonSerialize(using = JsonDateSerializer.class)
  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  @JsonSerialize(using = JsonDateSerializer.class)
  public Date getLastModifiedOn() {
    return lastModifiedOn;
  }

  public void setLastModifiedOn(Date lastModifiedOn) {
    this.lastModifiedOn = lastModifiedOn;
  }

  public Set<QuestionVO> getQuestions() {
    return questions;
  }

  public void setQuestions(Set<QuestionVO> questions) {
    this.questions = questions;
  }
}
