package br.com.duyllyan.consultorioodontologico.dto;

import br.com.duyllyan.consultorioodontologico.entities.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private Long id;
    private String street;
    private String number;
    private String district;
    private String city;
    private String state;

    public AddressDTO() {
    }

    public AddressDTO(Long id, String street, String number, String district, String city, String state) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.district = district;
        this.city = city;
        this.state = state;
    }

    public AddressDTO(Address address) {
        id = address.getId();
        street = address.getStreet();
        number = address.getNumber();
        district = address.getDistrict();
        city = address.getCity();
        state = address.getState();
    }
}
