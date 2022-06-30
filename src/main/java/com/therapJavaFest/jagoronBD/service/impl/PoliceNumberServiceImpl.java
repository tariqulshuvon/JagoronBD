package com.therapJavaFest.jagoronBD.service.impl;




import com.therapJavaFest.jagoronBD.model.PoliceNumber;
import com.therapJavaFest.jagoronBD.repository.PoliceNumberRepository;
import com.therapJavaFest.jagoronBD.service.PoliceNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PoliceNumberServiceImpl implements PoliceNumberService {

    @Autowired
    PoliceNumberRepository numberRepository;

    @Override
    public void save(PoliceNumber number) {
        numberRepository.save(number);
    }

    @Override
    public List<PoliceNumber> findAll() {
        return numberRepository.findAll();
    }

    @Override
    public List<PoliceNumber> findAllByDivisionId(Long divisionId) {
        return numberRepository.findAllByDivisionId(divisionId);
    }

    @Override
    public Optional<PoliceNumber> findById(Long id) {
        return numberRepository.findById(id);
    }

    @Override
    public void delete(Long id) {

        numberRepository.deleteById(id);
    }
}
