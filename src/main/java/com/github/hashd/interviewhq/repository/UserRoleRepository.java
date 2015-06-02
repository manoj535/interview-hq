package com.github.hashd.interviewhq.repository;

import com.github.hashd.interviewhq.model.auth.UserRole;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kd on 2/6/15.
 */
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
}
