package com.therapJavaFest.jagoronBD.service;



import com.therapJavaFest.jagoronBD.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    void save(Category category);

    Optional<Category> findById(Long id);

    List<Category> findAll();

    Optional<Category> findByName(String name);

}
