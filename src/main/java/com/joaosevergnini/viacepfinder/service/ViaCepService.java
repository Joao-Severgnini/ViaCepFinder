package com.joaosevergnini.viacepfinder.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.joaosevergnini.viacepfinder.client.ViaCepClient;
import com.joaosevergnini.viacepfinder.domain.model.Address;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ViaCepService {
    public Address findAddressByPostalCode(String postalCode) {

        String postalCodeFormatted = postalCode.replaceAll("\\D", "");

        if(postalCodeFormatted.length() != 8) {
            throw new IllegalArgumentException("Invalid postal code format.");
        }

        ViaCepClient viaCepClient = new ViaCepClient();
        var response = viaCepClient.getAddressByPostalCode(postalCodeFormatted);

        if(response == null || Boolean.TRUE.equals(response.erro())) {
            throw new IllegalArgumentException("Postal code not found.");
        }

        return new Address(response);
    }

    public void writeAddressJson(List<Address> addresses, String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(gson.toJson(addresses));
        }catch (IOException e){
            throw new RuntimeException("Error writing to file: " + e.getMessage());
        }
    }
}
