package com.joaosevergnini.viacepfinder.domain.model;

import com.joaosevergnini.viacepfinder.dto.ViaCepResponse;

public class Address {
    private final String postalCode;
    private final String street;
    private final String complement;
    private final String neighborhood;
    private final String city;
    private final String stateCode;
    private final String state;
    private final String region;
    private final String areaCode;

    public Address(
        String postalCode,
        String street,
        String complement,
        String neighborhood,
        String city,
        String stateCode,
        String state,
        String region,
        String areaCode
    ) {
        this.postalCode = postalCode;
        this.street = street;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.stateCode = stateCode;
        this.state = state;
        this.region = region;
        this.areaCode = areaCode;
    }

    public Address(ViaCepResponse viaCepResponse){
        this(
            viaCepResponse.cep(),
            viaCepResponse.logradouro(),
            viaCepResponse.complemento(),
            viaCepResponse.bairro(),
            viaCepResponse.localidade(),
            viaCepResponse.uf(),
            viaCepResponse.estado(),
            viaCepResponse.regiao(),
            viaCepResponse.ddd()
        );
    }

    @Override
    public String toString() {
        return "Address[ " +
                "postalCode= '" + postalCode + '\'' +
                ", street= '" + street + '\'' +
                ", complement= '" + complement + '\'' +
                ", neighborhood= '" + neighborhood + '\'' +
                ", city= '" + city + '\'' +
                ", stateCode= '" + stateCode + '\'' +
                ", state= '" + state + '\'' +
                ", region= '" + region + '\'' +
                ", areaCode= '" + areaCode + '\'' +
                 " ]";
    }
}
