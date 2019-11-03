package com.magalhaes_andre.zipkin_poc.mercado_livre.service;

import com.magalhaes_andre.zipkin_poc.mercado_livre.dto.Request;
import com.magalhaes_andre.zipkin_poc.mercado_livre.dto.Response;
import feign.Client;
import feign.Feign;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiCaller {

    public void call(Request request){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity("http://localhost:8082", request, Response.class);
    }

}
