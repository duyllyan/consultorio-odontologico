package br.com.duyllyan.consultorioodontologico.services;

import br.com.duyllyan.consultorioodontologico.dto.PatientDTO;
import br.com.duyllyan.consultorioodontologico.entities.Patient;
import br.com.duyllyan.consultorioodontologico.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public List<PatientDTO> findAll() {
        List<Patient> patients = repository.findAll();
        return patients.stream().map(patient -> new PatientDTO(patient)).collect(Collectors.toList());
    }
}
