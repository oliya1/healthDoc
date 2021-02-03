package com.nicico.healthDoc.dao;

import com.nicico.healthDoc.entity.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
    Optional<Personnel> findByPersonnelNo(Long personnelNo);
}
