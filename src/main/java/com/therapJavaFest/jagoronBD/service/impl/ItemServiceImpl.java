package com.therapJavaFest.jagoronBD.service.impl;



import com.therapJavaFest.jagoronBD.model.Item;
import com.therapJavaFest.jagoronBD.repository.ItemRepository;
import com.therapJavaFest.jagoronBD.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> findAllByCategoryId(Long categoryId) {
        return itemRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public void delete(Long id) {

        itemRepository.deleteById(id);
    }
}
