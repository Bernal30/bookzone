package com.zumito.bookzone.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//Clase dedicada a la conbversión de json a Java
public class DataConverter implements IDataConverter {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T dataConvert(String json, Class<T> genericClass) {
        try {
            return mapper.readValue(json, genericClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
