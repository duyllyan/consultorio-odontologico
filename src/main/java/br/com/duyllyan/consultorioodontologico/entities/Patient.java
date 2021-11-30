package br.com.duyllyan.consultorioodontologico.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tb_patient")
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String rg;
    private LocalDate registrationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    public Patient() {
    }

    public Patient(Long id, String name, String surname, String rg, LocalDate registrationDate, Address address, Dentist dentist) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.rg = rg;
        this.registrationDate = registrationDate;
        this.address = address;
        this.dentist = dentist;
    }
}
