package com.main.entityformatting.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entityformatting.entity.Filedata;
import com.main.entityformatting.repository.FileDataRepo;
import com.main.entityformatting.services.FileDataService;

@Service
public class FileDataServiceImpl implements FileDataService {

    @Autowired
    FileDataRepo fileDataRepo;

    @Override
    public void save(List<Filedata> list) {
        fileDataRepo.saveAll(list);
    }

}
