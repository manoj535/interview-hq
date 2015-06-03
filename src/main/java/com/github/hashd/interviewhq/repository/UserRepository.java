package com.github.hashd.interviewhq.repository;

import com.github.hashd.interviewhq.model.auth.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by kd on 2/6/15.
 */
@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, Long> {
}
