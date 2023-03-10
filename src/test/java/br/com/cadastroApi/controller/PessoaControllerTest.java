package br.com.cadastroApi.controller;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

class PessoaControllerTest {

    @Test
    void getAll() {
        URI uri = URI.create("http://localhost:8080/pessoas");
        HttpRequest.Builder builder = HttpRequest.newBuilder(uri);
        HttpRequest build = builder.GET().build();
        HttpResponse<String> response ;
        try {
            response = HttpClient.newHttpClient().send(build,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


        int responseStatusCode = response.statusCode();
        String body = response.body();
        assertEquals("[]", body);
        assertEquals(200, responseStatusCode);
    }

    @Test
    void getById() {
        URI uri = URI.create("http://localhost:8080/pessoas/1");
        HttpRequest.Builder builder = HttpRequest.newBuilder(uri);
        HttpRequest build = builder.GET().build();
        HttpResponse<String> response ;
        try {
            response = HttpClient.newHttpClient().send(build,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


        int responseStatusCode = response.statusCode();
        String body = response.body();
        assertEquals("", body);
        assertEquals(200, responseStatusCode);
    }





}