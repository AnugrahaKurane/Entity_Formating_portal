package com.main.entityformatting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entityformatting.entity.Filedata;
import com.main.entityformatting.services.FileDataService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/files")
public class FileDataController {

    @Autowired
    FileDataService fileDataService;

    @PostMapping("/upload")
    public void uploadFile(@RequestBody List<Filedata> list) {
        fileDataService.save(list);
    }
}
