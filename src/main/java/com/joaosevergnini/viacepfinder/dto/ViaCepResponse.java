package com.joaosevergnini.viacepfinder.dto;

public record ViaCepResponse(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf,
        String estado,
        String regiao,
        String ddd,
        Boolean erro
) {}
