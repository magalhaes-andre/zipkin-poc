package com.magalhaes.sleuth.scrambling_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class Scrambler {

    private Random random = new Random();

    public List<String> scrambleAll(List<String> words){
        return words
                .stream()
                .map(word -> scramble(word))
                .collect(Collectors.toList());
    }

    public String scramble(String word) {
        StringBuffer scrambledWord = new StringBuffer();
        List<Character> letters = word
                .chars()
                .mapToObj(character -> (char) character)
                .collect(Collectors.toList());

        Collections.shuffle(letters);

        letters.forEach(letter -> scrambledWord.append(letter));
        return scrambledWord.toString();
    }
}
