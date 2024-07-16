package com.zumito.bookzone.service;

//interfaze dedicada a la conversión abstracta de json a clase java desde cualquier API
public interface IDataConverter {
    <T> T dataConvert(String json, Class<T> classFromJson);
}
