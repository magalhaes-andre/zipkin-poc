package com.magalhaes_andre.zipkin_poc.mercado_livre.dto;

import com.magalhaes_andre.zipkin_poc.mercado_livre.service.IdCreator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class Request{
    private String header;
    private Map<String,String> content;

    public Request(Map content){
        this.content = content;
    }

    public Map<String, String> getContent(){
        return this.content;
    }

    public String getHeader() { return this.header; }

    public void setHeader(String header){
        this.header = header;
    }
}