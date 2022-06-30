package com.therapJavaFest.jagoronBD.service;



import com.therapJavaFest.jagoronBD.model.Division;

import java.util.List;
import java.util.Optional;

public interface DivisionService {

    void save(Division division);

    Optional<Division> findById(Long id);

    List<Division> findAll();

    Optional<Division> findByName(String name);

}
