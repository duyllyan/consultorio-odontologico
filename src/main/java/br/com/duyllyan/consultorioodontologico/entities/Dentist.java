package br.com.duyllyan.consultorioodontologico.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@Table(name = "tb_dentist")
public class Dentist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter private Long id;
    @Setter private Integer registrationNumber;
    @Setter private String name;
    @Setter private String surname;

    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    private List<Patient> patients = new ArrayList<>();

    public Dentist() {
    }

    public Dentist(Long id, Integer registrationNumber, String name, String surname) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.surname = surname;
    }
}
