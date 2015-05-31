package com.github.hashd.interviewhq.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by kd on 31/5/15.
 */
@Entity
@Table(name = "tags", uniqueConstraints = {@UniqueConstraint(columnNames = {"tag"})})
public class Tag {
  private Long   id;
  private String tag;
  private String description;
  private Date   createdOn;
  private Date   lastModifiedOn;

  private Set<QuestionTag> questionTags;

  public Tag() {
  }

  public Tag(String tag, String description, Date createdOn, Date lastModifiedOn) {
    this.tag = tag;
    this.description = description;
    this.createdOn = createdOn;
    this.lastModifiedOn = lastModifiedOn;
  }

  public Tag(Long id, String tag, String description, Date createdOn, Date lastModifiedOn) {
    this.id = id;
    this.tag = tag;
    this.description = description;
    this.createdOn = createdOn;
    this.lastModifiedOn = lastModifiedOn;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "tag_id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "tag")
  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  @Column(name = "description", length = 2048)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  @OneToMany(mappedBy = "tag", fetch = FetchType.EAGER)
  public Set<QuestionTag> getQuestionTags() {
    return questionTags;
  }

  public void setQuestionTags(Set<QuestionTag> questionTags) {
    this.questionTags = questionTags;
  }
}
