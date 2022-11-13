package com.main.entityformatting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entityformatting.entity.Filedata;

@Repository
public interface FileDataRepo extends JpaRepository<Filedata, Integer> {

}
