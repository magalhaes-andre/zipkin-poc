package com.magalhaes_andre.zipkin_poc.mercado_livre.service;

import com.magalhaes_andre.zipkin_poc.mercado_livre.dto.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestDealer {
    private List<Request> allRequests = new ArrayList<Request>();
    private String nextServiceUrl = "http://localhost:8082";

    @Autowired
    private IdCreator idCreator;

    public Request prepareRequest(Request request){
        return idCreator.generateHeader(request);
    }

    public Request sendRequest(Request request){
        return request;
    }
}
