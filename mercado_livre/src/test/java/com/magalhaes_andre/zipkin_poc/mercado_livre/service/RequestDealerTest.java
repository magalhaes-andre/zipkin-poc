package com.magalhaes_andre.zipkin_poc.mercado_livre.service;

import com.magalhaes_andre.zipkin_poc.mercado_livre.dto.Request;
import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.security.RunAs;
import java.util.HashMap;

@SpringBootTest()
public class RequestDealerTest {

    @Autowired
    RequestDealer requestDealer;

    @Test
    public void shouldReturnSomething(){
        HashMap<String ,String > map = new HashMap<>();
        map.put("cpf", "123456");
        requestDealer.prepareRequest(new Request(map));
    }
}
