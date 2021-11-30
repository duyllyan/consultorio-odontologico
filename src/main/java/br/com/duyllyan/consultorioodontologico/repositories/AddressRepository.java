package br.com.duyllyan.consultorioodontologico.repositories;

import br.com.duyllyan.consultorioodontologico.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
