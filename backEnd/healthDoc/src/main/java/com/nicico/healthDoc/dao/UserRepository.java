package com.nicico.healthDoc.dao;

import com.nicico.healthDoc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
