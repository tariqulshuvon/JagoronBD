package com.therapJavaFest.jagoronBD.service;

import com.therapJavaFest.jagoronBD.model.PoliceNumber;

import java.util.List;
import java.util.Optional;

public interface PoliceNumberService {

    void save(PoliceNumber number);

    List<PoliceNumber> findAll();

    List<PoliceNumber> findAllByDivisionId(Long divisionId);

    Optional<PoliceNumber> findById(Long id);

    void delete(Long id);

}
