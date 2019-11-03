package com.magalhaes.sleuth.capitalizing_service.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Capitalizer {

    public String capitalize(String word){
        return word.substring(0,1).toUpperCase() + word.substring(1);
    }

    public List<String> capitalizeThemAll(List<String> words){
        return words
                .stream()
                .map(word -> capitalize(word))
                .collect(Collectors.toList());
    }
}
