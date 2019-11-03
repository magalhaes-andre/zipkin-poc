package com.magalhaes.sleuth.sorting_service.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class SorterTest {

    @Autowired private Sorter sorter;

    private final List<String> TESTING_WORDS = Arrays.asList("game", "almond", "ball", "airplane");
    private final List<String> EXPECTED_ORDERED_WORDS_ALPHABETICALLY = Arrays.asList("airplane", "almond", "ball", "game");

    @Test
    public void shouldReturnAProperlySortedList(){
        Assertions.assertEquals(EXPECTED_ORDERED_WORDS_ALPHABETICALLY, sorter.sortAlphabetically(TESTING_WORDS));
    }
}
