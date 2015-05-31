package com.github.hashd.interviewhq;

import com.github.hashd.interviewhq.model.Question;
import com.github.hashd.interviewhq.model.QuestionTag;
import com.github.hashd.interviewhq.model.Tag;
import com.github.hashd.interviewhq.repository.QuestionRepository;
import com.github.hashd.interviewhq.repository.QuestionTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
public class InterviewHqApplication implements CommandLineRunner {
  @Autowired
  private QuestionTagRepository questionTagRepository;

  @Autowired
  private QuestionRepository questionRepository;

  public static void main(String[] args) {
    SpringApplication.run(InterviewHqApplication.class, args);
  }

  @Override
  public void run(String... strings) throws Exception {
    Question q1 = new Question("Who is this?", new Date(), new Date());
    Question q2 = new Question("Why seek this position?", new Date(), new Date());
    Question q3 = new Question("Do you have any questions?", new Date(), new Date());

    Tag t1 = new Tag("PERSONAL", "Not related to technology", new Date(), new Date());
    Tag t2 = new Tag("BACKEND", "Middleware Stack", new Date(), new Date());
    Tag t3 = new Tag("FRONTEND", "UI Stack", new Date(), new Date());

    QuestionTag qt1 = new QuestionTag(q1, t1);
    QuestionTag qt2 = new QuestionTag(q2, t2);
    QuestionTag qt3 = new QuestionTag(q3, t3);

    questionTagRepository.save(Arrays.<QuestionTag>asList(qt1, qt2, qt3));

    Question q = questionRepository.findOne(1L);
    System.out.println(q.getQuestionTags());
  }
}
