package com.project.triple.repository;

import com.project.triple.model.entity.User.AdminUser;
import com.project.triple.model.entity.User.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

    Optional<AdminUser> findByUseridAndUserpw(String userid, String userpw);

    Optional<AdminUser> findByUserid(String userid);

    List<AdminUser> findAllByOrderByIdxDesc();
}
