package com.github.hashd.interviewhq.repository;

import com.github.hashd.interviewhq.model.Question;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kd on 31/5/15.
 */
public interface QuestionRepository extends CrudRepository<Question, Long> {
}
