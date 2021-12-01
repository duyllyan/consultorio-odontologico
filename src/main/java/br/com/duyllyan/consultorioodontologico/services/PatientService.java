package br.com.duyllyan.consultorioodontologico.services;

import br.com.duyllyan.consultorioodontologico.dto.PatientDTO;
import br.com.duyllyan.consultorioodontologico.entities.Address;
import br.com.duyllyan.consultorioodontologico.entities.Dentist;
import br.com.duyllyan.consultorioodontologico.entities.Patient;
import br.com.duyllyan.consultorioodontologico.repositories.AddressRepository;
import br.com.duyllyan.consultorioodontologico.repositories.DentistRepository;
import br.com.duyllyan.consultorioodontologico.repositories.PatientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private static final Logger LOG = LogManager.getLogger(PatientService.class);

    @Autowired
    private PatientRepository repository;

    @Autowired
    private DentistRepository dentistRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Transactional(readOnly = true)
    public List<PatientDTO> findAll() {
        LOG.debug("searching all patients");
        List<Patient> patients = repository.findAll();
        LOG.info("found {} patients", patients.size());
        return patients.stream().map(PatientDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PatientDTO findById(Long id) {
        LOG.debug("searching patient by id {}", id);
        Patient patient = repository.findById(id).get();
        LOG.info("found patient {}", patient);
        return new PatientDTO(patient);
    }

    @Transactional(readOnly = true)
    public List<PatientDTO> findByDentistId(Long id) {
        LOG.debug("searching patients by dentist id {}", id);
        List<Patient> patients = repository.findByDentistId(id);
        LOG.info("found {} patients", patients.size());
        return patients.stream().map(PatientDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public PatientDTO save(PatientDTO patientDTO) {
        LOG.debug("saving patient {}", patientDTO.getName());
        Dentist dentist = null;
        Address address = addressRepository.save(new Address(
                    null,
                    patientDTO.getAddress().getStreet(),
                    patientDTO.getAddress().getNumber(),
                    patientDTO.getAddress().getNeighborhood(),
                    patientDTO.getAddress().getCity(),
                    patientDTO.getAddress().getState(),
                    patientDTO.getAddress().getCountry(),
                    patientDTO.getAddress().getZipCode()
        ));

        if (patientDTO.getDentist() != null) {
            dentist = dentistRepository.getById(patientDTO.getDentist().getId());
        }
        Patient patient = new Patient(
                null,
                patientDTO.getName(),
                patientDTO.getSurname(),
                patientDTO.getRg(),
                LocalDate.now(),
                address,
                dentist);
        patient = repository.save(patient);
        LOG.info("saved patient {}", patient.getName());
        return new PatientDTO(patient);
    }

    @Transactional
    public void delete(Long id) {
        LOG.debug("deleting patient by id {}", id);
        repository.deleteById(id);
        LOG.info("deleted patient by id {}", id);
    }

    @Transactional
    public PatientDTO update(Long id, PatientDTO patientDTO) {
        LOG.debug("updating patient by id {}", id);
        Patient patient = repository.findById(id).get();
        patient.setName(patientDTO.getName());
        patient.setSurname(patientDTO.getSurname());
        patient.setRg(patientDTO.getRg());
        patient.getAddress().setStreet(patientDTO.getAddress().getStreet());
        patient.getAddress().setNumber(patientDTO.getAddress().getNumber());
        patient.getAddress().setNeighborhood(patientDTO.getAddress().getNeighborhood());
        patient.getAddress().setCity(patientDTO.getAddress().getCity());
        patient.getAddress().setState(patientDTO.getAddress().getState());
        patient.getAddress().setCountry(patientDTO.getAddress().getCountry());
        patient.getAddress().setZipCode(patientDTO.getAddress().getZipCode());
        patient = repository.save(patient);
        if (patientDTO.getDentist() != null) {
            patient.setDentist(dentistRepository.getById(patientDTO.getDentist().getId()));
        }
        LOG.info("updated patient {}", patient.getName());
        return new PatientDTO(patient);
    }
}
