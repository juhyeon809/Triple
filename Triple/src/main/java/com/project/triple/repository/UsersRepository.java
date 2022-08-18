package com.project.triple.repository;

import com.project.triple.model.entity.User.AdminUser;
import com.project.triple.model.entity.User.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {


    Optional<Users> findByEmailAndUserpw(String email, String userpw);

    Optional<Users> findByEmail(String email);

    Optional<Users> findByUserpw(String userpw);

    List<Users> findAllByOrderByIdxDesc();

    Users findAllByEmail(String email);

}
