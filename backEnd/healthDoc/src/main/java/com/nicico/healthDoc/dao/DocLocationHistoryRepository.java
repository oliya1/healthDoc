package com.nicico.healthDoc.dao;

import com.nicico.healthDoc.entity.DocLocationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DocLocationHistoryRepository extends JpaRepository<DocLocationHistory, Long> {
    List<DocLocationHistory>  findAllByBarcode(Long barcode);

    @Query(value = "select max(doc_level) from DOC_LOCATION_HISTORY where barcode = ?", nativeQuery = true)
    int getMaxLevel(Long barcode);
}
