package com.nicico.healthDoc.dao;

import com.nicico.healthDoc.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(collectionResourceRel = "location", path = "location")
public interface LocationRepository extends JpaRepository<Location, Long> {
}
