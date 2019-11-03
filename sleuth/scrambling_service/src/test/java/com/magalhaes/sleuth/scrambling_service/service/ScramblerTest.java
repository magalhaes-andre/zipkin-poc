package com.magalhaes.sleuth.scrambling_service.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class ScramblerTest {

    private final List<String> WORDS_TO_SCRAMBLE = Arrays.asList("airplane", "paralelepipedo", "cavaloMemes");
    private final String WORD_TO_SCRAMBLE = "airplane";
    @Autowired private Scrambler scrambler;

    @Test
    public void shouldScrambleMaintainingWordSize(){
        String scrambledWord = scrambler.scramble(WORD_TO_SCRAMBLE);

        Assertions.assertTrue(checkIfWordHasChanged(WORD_TO_SCRAMBLE, scrambledWord));
    }

    @Test
    public void shouldScrambleEachWordInTheList(){
        List<String> scrambledWords = scrambler.scrambleAll(WORDS_TO_SCRAMBLE);

        Assertions.assertTrue(checkIfWordListHasChanged(WORDS_TO_SCRAMBLE, scrambledWords));
    }

    private boolean checkIfWordHasChanged(String oldWord, String newWord){
        return oldWord.length() == newWord.length() &&
                !oldWord.equals(newWord) ? true : false;
    }

    private boolean checkIfWordListHasChanged(List<String> oldWords, List<String> newWords){
        List<Boolean> changedWords = newWords
                .stream()
                .map(word -> checkIfWordHasChanged(oldWords.get(newWords.indexOf(word)), word))
                .collect(Collectors.toList());
        oldWords.forEach(word -> System.out.println(word));
        newWords.forEach(word -> System.out.println(word));
        return !changedWords.contains(false);
    }
}
