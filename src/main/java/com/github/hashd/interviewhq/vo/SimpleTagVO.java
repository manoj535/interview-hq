package com.github.hashd.interviewhq.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.hashd.interviewhq.model.Tag;
import com.github.hashd.interviewhq.utils.serializer.JsonDateSerializer;

import java.util.Date;

/**
 * Created by kd on 31/5/15.
 */
public class SimpleTagVO {
  private Long   id;
  private String tag;
  private String description;
  private Date   createdOn;
  private Date   lastModifiedOn;

  public SimpleTagVO(Tag tag) {
    this.id = tag.getId();
    this.tag = tag.getTag();
    this.description = tag.getDescription();
    this.createdOn = tag.getCreatedOn();
    this.lastModifiedOn = tag.getLastModifiedOn();
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
}
