package br.com.duyllyan.consultorioodontologico.repositories;

import br.com.duyllyan.consultorioodontologico.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Long> {
}
