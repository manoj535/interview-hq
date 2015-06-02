package com.github.hashd.interviewhq;

import com.github.hashd.interviewhq.model.Answer;
import com.github.hashd.interviewhq.model.Question;
import com.github.hashd.interviewhq.model.QuestionTag;
import com.github.hashd.interviewhq.model.Tag;
import com.github.hashd.interviewhq.model.enums.Difficulty;
import com.github.hashd.interviewhq.repository.QuestionRepository;
import com.github.hashd.interviewhq.repository.QuestionTagRepository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class InterviewHQ implements CommandLineRunner {

  @Bean
  InitializingBean populateTestData(QuestionTagRepository questionTagRepository) {
    return () -> {
      SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("user", "n/a", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER")));

      Question q1 = new Question("Who is this?", Difficulty.EASY);
      Question q2 = new Question("Why seek this position?", Difficulty.HARD);
      Question q3 = new Question("Do you have any questions?", Difficulty.MEDIUM);

      Tag t1 = new Tag("PERSONAL", "Not related to technology", new Date(), new Date());
      Tag t2 = new Tag("BACKEND", "Middleware Stack", new Date(), new Date());
      Tag t3 = new Tag("FRONTEND", "UI Stack", new Date(), new Date());

      QuestionTag qt1 = new QuestionTag(q1, t1);
      QuestionTag qt2 = new QuestionTag(q2, t2);
      QuestionTag qt3 = new QuestionTag(q3, t3);
      
      Answer a1 = new Answer(q1, "answer to q1");
      Answer a2 = new Answer(q1, "answer to q1");
      
      q1.setAnswers(Arrays.asList(a1, a2));
      questionTagRepository.save(Arrays.<QuestionTag>asList(qt1, qt2, qt3));
    };
  }

  public static void main(String[] args) {
    SpringApplication.run(InterviewHQ.class, args);
  }

  @Override
  public void run(String... strings) throws Exception {

  }
}
