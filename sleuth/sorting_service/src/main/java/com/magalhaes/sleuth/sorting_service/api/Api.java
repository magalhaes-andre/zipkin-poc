package com.magalhaes.sleuth.sorting_service.api;

import com.magalhaes.sleuth.sorting_service.config.ServiceConfiguration;
import com.magalhaes.sleuth.sorting_service.service.Sorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class Api {

    @Autowired
    private ServiceConfiguration config;

    @Autowired
    private Sorter sorter;
    
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/")
    public List<String> processWords(@RequestBody List<String> words){
        List<String> sortedWords = sorter.sortAlphabetically(words);
        return restTemplate.postForObject(config.getSCRAMBLING_SERVICE_URI(), sortedWords, List.class);
    }
}
