package com.github.hashd.interviewhq.controller;

import com.github.hashd.interviewhq.model.Question;
import com.github.hashd.interviewhq.model.enums.Difficulty;
import com.github.hashd.interviewhq.repository.QuestionRepository;
import com.github.hashd.interviewhq.repository.TagRepository;
import com.github.hashd.interviewhq.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kd on 31/5/15.
 */
@RestController
@RequestMapping("/rest/api")
public class InterviewHQController {
  @Autowired
  QuestionRepository questionRepository;

  @Autowired
  TagRepository tagRepository;

  @RequestMapping(value = "/questions/{id}", method = RequestMethod.GET)
  public QuestionVO question(@PathVariable Long id) {
    return new QuestionVO(questionRepository.findOne(id));
  }

  @RequestMapping(value = "/question", method = RequestMethod.POST)
  public QuestionVO addQuestion(@RequestParam("content") String content, @RequestParam(value = "difficulty", defaultValue = "MEDIUM") String difficulty) {
    Question question = new Question(content, Difficulty.valueOf(difficulty));
    questionRepository.save(question);

    return new QuestionVO(question);
  }
}
