package br.com.duyllyan.consultorioodontologico.repositories;

import br.com.duyllyan.consultorioodontologico.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
