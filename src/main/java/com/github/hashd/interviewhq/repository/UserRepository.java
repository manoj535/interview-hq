package com.github.hashd.interviewhq.repository;

import com.github.hashd.interviewhq.model.auth.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kd on 2/6/15.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
