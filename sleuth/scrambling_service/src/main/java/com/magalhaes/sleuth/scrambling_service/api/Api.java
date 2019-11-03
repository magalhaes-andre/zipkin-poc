package com.magalhaes.sleuth.scrambling_service.api;

import com.magalhaes.sleuth.scrambling_service.config.ServiceConfiguration;
import com.magalhaes.sleuth.scrambling_service.service.Scrambler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Api {

    @Autowired
    private Scrambler scrambler;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ServiceConfiguration config;

    @PostMapping("/")
    public List<String> scrambleWords(@RequestBody List<String> words){
        List<String> scrambledWords = scrambler.scrambleAll(words);
        return restTemplate.postForObject(config.getCapitalizingServiceUri(), scrambledWords, List.class);
    }
}
