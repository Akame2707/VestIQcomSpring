package com.senai.vestiq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.vestiq.entity.Material;

@Repository 
public interface MaterialRepository extends JpaRepository<Material, Long>{

}
