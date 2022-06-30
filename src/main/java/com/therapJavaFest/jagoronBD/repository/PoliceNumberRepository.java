package com.therapJavaFest.jagoronBD.repository;


import com.therapJavaFest.jagoronBD.model.Item;
import com.therapJavaFest.jagoronBD.model.PoliceNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoliceNumberRepository extends JpaRepository<PoliceNumber, Long> {

    List<PoliceNumber> findAllByDivisionId(Long divisionId);
}
