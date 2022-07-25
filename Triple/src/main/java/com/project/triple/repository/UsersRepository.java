package com.project.triple.repository;

import com.project.triple.model.entity.User.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {


    Optional<Users> findByEmailAndUserpw(String email, String userpw);

    Optional<Users> findByEmail(String email);
}
