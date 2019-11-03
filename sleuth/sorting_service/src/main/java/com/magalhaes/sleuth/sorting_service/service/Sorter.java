package com.magalhaes.sleuth.sorting_service.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class Sorter {

    public List<String> sortAlphabetically(List<String> words){
        return words.stream().sorted().collect(Collectors.toList());
    }
}
