package com.therapJavaFest.jagoronBD.service.impl;


import com.therapJavaFest.jagoronBD.model.Role;
import com.therapJavaFest.jagoronBD.repository.RoleRepository;
import com.therapJavaFest.jagoronBD.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;





    @Override
    public Role findById(Long id) {
        return roleRepository.getById(id);
    }
}
