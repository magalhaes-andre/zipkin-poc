package com.magalhaes_andre.zipkin_poc.mercado_livre.service;

import com.magalhaes_andre.zipkin_poc.mercado_livre.dto.Request;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class IdCreator {

    public Request generateHeader(Request request) {
        request.setHeader(generateId(request.getContent()));
        return request;
    }

    private String generateId(Map content) {
        return String.valueOf(content.hashCode());
    }
}
