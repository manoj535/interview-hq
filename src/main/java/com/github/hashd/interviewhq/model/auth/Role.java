package com.github.hashd.interviewhq.model.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by kd on 2/6/15.
 */
public enum Role {
  USER, INTERVIEWER, ADMIN
}
