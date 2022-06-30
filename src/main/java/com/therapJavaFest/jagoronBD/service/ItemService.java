package com.therapJavaFest.jagoronBD.service;


import com.therapJavaFest.jagoronBD.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    void save(Item item);

    List<Item> findAll();

    List<Item> findAllByCategoryId(Long categoryId);

    Optional<Item> findById(Long id);

    void delete(Long id);
}
