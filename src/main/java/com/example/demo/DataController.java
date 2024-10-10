package com.example.demo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Slf4j
public class DataController {

    @PostMapping
    public String handle(@RequestPart("data") List<MetaDataDTO> data) {
        data.forEach(d -> {
            log.info("Metadata: {}", d.getMetadata());
            d.getFiles().forEach(f -> log.info("File: {}", f.getOriginalFilename()));
        });
        return "Data received successfully";
    }

    @Data
    public static class MetaData {
        private String name;
        private String description;
    }

    @Data
    public static class MetaDataDTO {
        private MetaData metadata;
        private List<MultipartFile> files;
    }

}
