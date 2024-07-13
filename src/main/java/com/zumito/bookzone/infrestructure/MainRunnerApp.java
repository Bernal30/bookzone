package com.zumito.bookzone.infrestructure;


import com.zumito.bookzone.models.DataBooks;
import com.zumito.bookzone.models.GeneralData;
import com.zumito.bookzone.service.ApiRequest;
import com.zumito.bookzone.service.DataConverter;

import java.util.Comparator;

public class MainRunnerApp {
    private static final String URL_BASE = "https://gutendex.com/books/?";
    //instancias de clases
    private ApiRequest apiRequest = new ApiRequest();
    private DataConverter dataConverter = new DataConverter();

    public void showMenu() {
        var json = apiRequest.obtenerDatos(URL_BASE);
        System.out.println(json);
        var booksGeneralData = dataConverter.dataConvert(json, GeneralData.class);
        System.out.println(booksGeneralData);

        //top 10 libros con más descargas
        System.out.println("top 10 libros con más descargas");
        booksGeneralData.resultsList().stream()
                .sorted(Comparator.comparing(DataBooks::downloads).reversed()) //sortea los libros por descargas de mayor a menor
                .limit(10) //limita el total del sorteo a solo mostrar los 10 primeros
                .map(b -> b.title().toUpperCase())
                .forEach(System.out::println); //muestra los 10 libros de la lista
    }
}
