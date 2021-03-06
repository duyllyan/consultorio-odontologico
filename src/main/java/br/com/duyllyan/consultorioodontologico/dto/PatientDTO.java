package br.com.duyllyan.consultorioodontologico.dto;

import br.com.duyllyan.consultorioodontologico.entities.Patient;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class PatientDTO implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private String rg;
    private LocalDate registrationDate;

    private AddressDTO address;
    private DentistDTO dentist;

    public PatientDTO() {
    }

    public PatientDTO(Long id, String name, String surname, String rg, LocalDate registrationDate, AddressDTO address, DentistDTO dentist) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.rg = rg;
        this.registrationDate = registrationDate;
        this.address = address;
        this.dentist = dentist;
    }

    public PatientDTO(Patient patient) {
        id = patient.getId();
        name = patient.getName();
        surname = patient.getSurname();
        rg = patient.getRg();
        registrationDate = patient.getRegistrationDate();
        address = patient.getAddress() != null ? new AddressDTO(patient.getAddress()) : null;
        dentist = patient.getDentist() != null ? new DentistDTO(patient.getDentist()) : null;
    }
}
