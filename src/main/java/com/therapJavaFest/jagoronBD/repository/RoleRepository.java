package com.therapJavaFest.jagoronBD.repository;

import com.therapJavaFest.jagoronBD.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
