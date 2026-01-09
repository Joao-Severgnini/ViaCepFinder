package com.joaosevergnini.viacepfinder.client;

import com.google.gson.Gson;
import com.joaosevergnini.viacepfinder.dto.ViaCepResponse;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepClient {
    public ViaCepResponse getAddressByPostalCode(String postalCode) {

        Gson gson = new Gson();
        String path = String.format("https://viacep.com.br/ws/%s/json/", postalCode);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(path))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return gson.fromJson(response.body(), ViaCepResponse.class);
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }
}
