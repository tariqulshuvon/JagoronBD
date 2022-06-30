package com.therapJavaFest.jagoronBD.repository;


import com.therapJavaFest.jagoronBD.model.Category;
import com.therapJavaFest.jagoronBD.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DivisionRepository extends JpaRepository<Division,Long> {

    Optional<Division> findByName(String name);
}
