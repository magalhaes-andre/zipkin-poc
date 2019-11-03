package com.magalhaes.sleuth.sorting_service.config;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ServiceConfigurationTest {

    @Autowired
    Environment env;

    @Autowired
    private ServiceConfiguration config ;

    @Test
    public void verifyConfigurationHasBeenFetched(){
        Assertions.assertNotNull(config);
        Assert.assertTrue(config.getSCRAMBLING_SERVICE_URI().equals(env.getProperty("scrambling_service_uri")) );
    }
}
