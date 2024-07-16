package com.zumito.bookzone.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//clase record dedicada a mapear la lista general de los libros
@JsonIgnoreProperties(ignoreUnknown = true)
public record GeneralData(
        @JsonAlias("results") List<DataBooks> resultsList
) {
}
