package br.com.duyllyan.consultorioodontologico.dto;

import br.com.duyllyan.consultorioodontologico.entities.Dentist;
import br.com.duyllyan.consultorioodontologico.entities.Patient;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class DentistDTO {

    private Long id;
    private Integer registrationNumber;
    private String name;
    private String surname;

    public DentistDTO() {
    }

    public DentistDTO(Long id, Integer registrationNumber, String name, String surname) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.surname = surname;
    }

    public DentistDTO(Dentist dentist) {
        id = dentist.getId();
        registrationNumber = dentist.getRegistrationNumber();
        name = dentist.getName();
        surname = dentist.getSurname();
    }

}
