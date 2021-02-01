package com.nicico.healthDoc.dao;

import com.nicico.healthDoc.entity.DocLocationHistory;
import com.nicico.healthDoc.entity.Location;
import com.nicico.healthDoc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DocLocationHistoryRepository extends JpaRepository<DocLocationHistory, Long> {
    List<DocLocationHistory> findByBarcode(String barcode);

    @Query(value = "select max(doc_level) from doc_location_history where barcode = ?", nativeQuery = true)
    Optional<Integer> getMaxLevel(String barcode);
//    int getMaxLevel(String barcode);

    @Modifying
    @Transactional
    @Query("update DocLocationHistory d set d.receiver = :receiver, d.location = :location, d.dateTime = :dateUpdate where d.id = :id")
    void updateDoc(
            @Param(value = "id") long id,
            @Param(value = "receiver") User receiver,
            @Param(value = "location") Location location,
            @Param(value = "dateUpdate")Date dateUpdate
            );
}
