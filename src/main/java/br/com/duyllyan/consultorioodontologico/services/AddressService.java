package br.com.duyllyan.consultorioodontologico.services;

import br.com.duyllyan.consultorioodontologico.dto.AddressDTO;
import br.com.duyllyan.consultorioodontologico.entities.Address;
import br.com.duyllyan.consultorioodontologico.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    @Transactional(readOnly = true)
    public AddressDTO findById(Long id) {
        Address address = repository.findById(id).get();
        return new AddressDTO(address);
    }
}
