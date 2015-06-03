package com.github.hashd.interviewhq;

import com.github.hashd.interviewhq.model.Answer;
import com.github.hashd.interviewhq.model.Comment;
import com.github.hashd.interviewhq.model.Question;
import com.github.hashd.interviewhq.model.QuestionTag;
import com.github.hashd.interviewhq.model.Tag;
import com.github.hashd.interviewhq.model.auth.Role;
import com.github.hashd.interviewhq.model.auth.User;
import com.github.hashd.interviewhq.model.auth.UserRole;
import com.github.hashd.interviewhq.model.enums.Difficulty;
import com.github.hashd.interviewhq.model.enums.Gender;
import com.github.hashd.interviewhq.repository.QuestionRepository;
import com.github.hashd.interviewhq.repository.QuestionTagRepository;

import com.github.hashd.interviewhq.repository.UserRepository;
import com.github.hashd.interviewhq.repository.UserRoleRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class InterviewHQ implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(InterviewHQ.class, args);
  }

  @Override
  public void run(String... strings) throws Exception {

  }
}
