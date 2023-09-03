package org.jjinppang.jjinppang.domain.user.repository;


import org.jjinppang.jjinppang.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserId(Integer userId);

    Optional<User> findByUserName(String userName);
}