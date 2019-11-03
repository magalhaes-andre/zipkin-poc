package com.magalhaes.sleuth.capitalizing_service.api;

import com.magalhaes.sleuth.capitalizing_service.service.Capitalizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Api {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Capitalizer capitalizer;

    @PostMapping("/")
    public List<String> capitalizeWords(@RequestBody List<String> words){
        return capitalizer.capitalizeThemAll(words);
    }
}
