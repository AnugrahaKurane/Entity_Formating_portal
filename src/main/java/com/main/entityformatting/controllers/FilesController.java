// package com.main.entityformatting.controllers;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
// import
// org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
// import org.springframework.core.io.ByteArrayResource;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// import com.main.entityformatting.entity.FileDB;
// import com.main.entityformatting.payloads.ResponseFile;
// import com.main.entityformatting.payloads.ResponseMessage;
// import com.main.entityformatting.services.FileService;

// @CrossOrigin(origins = "http://localhost:3000")
// @RestController
// @RequestMapping("/api/files")
// public class FilesController {

// @Autowired
// private FileService fileService;

// @PostMapping("/upload")
// public ResponseEntity<String> uploadFile(@RequestBody List<FileDB> data) {
// if (data != null) {
// fileService.save(data);
// return new ResponseEntity<String>("Uploaded successfully", HttpStatus.OK);
// }
// return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
// }
// }
