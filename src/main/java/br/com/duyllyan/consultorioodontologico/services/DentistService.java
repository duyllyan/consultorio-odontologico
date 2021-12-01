package br.com.duyllyan.consultorioodontologico.services;

import br.com.duyllyan.consultorioodontologico.dto.DentistDTO;
import br.com.duyllyan.consultorioodontologico.entities.Address;
import br.com.duyllyan.consultorioodontologico.entities.Dentist;
import br.com.duyllyan.consultorioodontologico.repositories.DentistRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DentistService {

    private static final Logger LOG = LogManager.getLogger(DentistService.class);

    @Autowired
    private DentistRepository repository;

    @Transactional(readOnly = true)
    public DentistDTO findById(Long id) {
        LOG.debug("searching dentist by id: " + id);
        Dentist dentist = repository.findById(id).get();
        LOG.info("found Dentist: " + dentist.getName());
        return new DentistDTO(dentist);
    }

    @Transactional(readOnly = true)
    public List<DentistDTO> findAll() {
        LOG.debug("searching all dentists");
        List<Dentist> dentists = repository.findAll();
        LOG.info("found Dentists: " + dentists.size());
        return dentists.stream().map(DentistDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public DentistDTO save(DentistDTO dentistDTO) {
        LOG.debug("saving dentist: " + dentistDTO.getName());
        Dentist dentist = new Dentist(
                null,
                dentistDTO.getRegistrationNumber(),
                dentistDTO.getName(),
                dentistDTO.getSurname()
        );
        dentist = repository.save(dentist);
        LOG.info("saved Dentist: " + dentist.getName());
        return new DentistDTO(dentist);
    }

    @Transactional
    public DentistDTO update(Long id, DentistDTO dentistDTO) {
        LOG.debug("updating dentist: " + dentistDTO.getName());
        Dentist dentist = repository.findById(id).get();
        dentist.setRegistrationNumber(dentistDTO.getRegistrationNumber());
        dentist.setName(dentistDTO.getName());
        dentist.setSurname(dentistDTO.getSurname());
        dentist = repository.save(dentist);
        LOG.info("updated Dentist: " + dentist.getName());
        return new DentistDTO(dentist);
    }

    @Transactional
    public void delete(Long id) {
        LOG.debug("deleting dentist by id: " + id);
        repository.deleteById(id);
        LOG.info("deleted Dentist");
    }
}
