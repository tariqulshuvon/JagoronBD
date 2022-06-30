package com.therapJavaFest.jagoronBD.service.impl;


import com.therapJavaFest.jagoronBD.model.Category;
import com.therapJavaFest.jagoronBD.model.Division;
import com.therapJavaFest.jagoronBD.repository.DivisionRepository;
import com.therapJavaFest.jagoronBD.service.CategoryService;
import com.therapJavaFest.jagoronBD.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DivisionServiceImpl implements DivisionService {

    @Autowired
    DivisionRepository divisionRepository;

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public Optional<Division> findById(Long id) {
        return divisionRepository.findById(id);
    }

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Optional<Division> findByName(String name) {
        return divisionRepository.findByName(name);
    }

}
