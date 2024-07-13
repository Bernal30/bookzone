package com.zumito.bookzone.infrestructure;


import com.zumito.bookzone.models.DataBooks;
import com.zumito.bookzone.models.GeneralData;
import com.zumito.bookzone.service.ApiRequest;
import com.zumito.bookzone.service.DataConverter;

import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

public class MainRunnerApp {
    private static final String URL_BASE = "https://gutendex.com/books/";
    //instancias de clases
    private ApiRequest apiRequest = new ApiRequest();
    private DataConverter dataConverter = new DataConverter();
    Scanner input = new Scanner(System.in);

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

        //Busqueda de libros por nombre
        System.out.println("Escriba el titulo del libro que desea buscar: ");
        var bookToSearch = input.nextLine();
        json = apiRequest.obtenerDatos(URL_BASE+"?search="+bookToSearch.replace(" ", "+"));
        var booksResult = dataConverter.dataConvert(json, GeneralData.class);
        System.out.println(booksResult);

        //se emplea un optional del tipo "DataBook" porque puede o no puede encontrar el libro
        Optional<DataBooks> searchedBook = booksResult.resultsList().stream()
                .filter(b -> b.title().toUpperCase().contains(bookToSearch.toUpperCase())) //se filtra por titulo entre los libros de la lista y el input del ususario (ambos en mayusculas para evitar discrepancias)
                .findFirst();
        //si encuentra el libro
        if(searchedBook.isPresent()) {
            System.out.println("Libro encontrado!");
            System.out.println(searchedBook.get()); //se muestran todos los datos
        }

    }
}
