package br.com.duyllyan.consultorioodontologico.services;

import br.com.duyllyan.consultorioodontologico.dto.DentistDTO;
import br.com.duyllyan.consultorioodontologico.entities.Dentist;
import br.com.duyllyan.consultorioodontologico.repositories.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DentistService {

    @Autowired
    private DentistRepository repository;

    @Transactional(readOnly = true)
    public DentistDTO findById(Long id) {
        Dentist dentist = repository.findById(id).get();
        return new DentistDTO(dentist);
    }

    @Transactional(readOnly = true)
    public List<DentistDTO> findAll() {
        List<Dentist> dentists = repository.findAll();
        return dentists.stream().map(DentistDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public DentistDTO save(DentistDTO dentistDTO) {
        Dentist dentist = new Dentist(
                null,
                dentistDTO.getRegistrationNumber(),
                dentistDTO.getName(),
                dentistDTO.getSurname()
        );
        dentist = repository.save(dentist);
        return new DentistDTO(dentist);
    }

    @Transactional
    public DentistDTO update(Long id, DentistDTO dentistDTO) {
        Dentist dentist = repository.findById(id).get();
        dentist.setRegistrationNumber(dentistDTO.getRegistrationNumber());
        dentist.setName(dentistDTO.getName());
        dentist.setSurname(dentistDTO.getSurname());
        dentist = repository.save(dentist);
        return new DentistDTO(dentist);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
