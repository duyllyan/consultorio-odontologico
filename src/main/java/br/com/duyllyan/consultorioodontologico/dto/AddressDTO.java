package br.com.duyllyan.consultorioodontologico.dto;

import br.com.duyllyan.consultorioodontologico.entities.Address;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AddressDTO implements Serializable {
    private Long id;
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public AddressDTO() {
    }

    public AddressDTO(Long id, String street, String number, String neighborhood, String city, String state, String country, String zipCode) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public AddressDTO(Address address) {
        id = address.getId();
        street = address.getStreet();
        number = address.getNumber();
        neighborhood = address.getNeighborhood();
        city = address.getCity();
        state = address.getState();
        country = address.getCountry();
        zipCode = address.getZipCode();
    }
}
