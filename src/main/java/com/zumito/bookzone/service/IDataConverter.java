package com.zumito.bookzone.service;

public interface IDataConverter {
    <T> T dataConvert(String json, Class<T> classFromJson);
}
