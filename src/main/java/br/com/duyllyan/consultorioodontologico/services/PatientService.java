package br.com.duyllyan.consultorioodontologico.services;

import br.com.duyllyan.consultorioodontologico.dto.PatientDTO;
import br.com.duyllyan.consultorioodontologico.entities.Address;
import br.com.duyllyan.consultorioodontologico.entities.Dentist;
import br.com.duyllyan.consultorioodontologico.entities.Patient;
import br.com.duyllyan.consultorioodontologico.repositories.AddressRepository;
import br.com.duyllyan.consultorioodontologico.repositories.DentistRepository;
import br.com.duyllyan.consultorioodontologico.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    @Autowired
    private DentistRepository dentistRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<PatientDTO> findAll() {
        List<Patient> patients = repository.findAll();
        return patients.stream().map(PatientDTO::new).collect(Collectors.toList());
    }

    public PatientDTO findById(Long id) {
        Patient patient = repository.findById(id).get();
        return new PatientDTO(patient);
    }

    public PatientDTO save(PatientDTO patientDTO) {
        Address address = addressRepository.getById(patientDTO.getAddress().getId());
        Dentist dentist = dentistRepository.getById(patientDTO.getDentist().getId());
        Patient patient = new Patient(
                null,
                patientDTO.getName(),
                patientDTO.getSurname(),
                patientDTO.getRg(),
                LocalDate.now(),
                address,
                dentist);
        patient = repository.save(patient);
        return new PatientDTO(patient);
    }
}
