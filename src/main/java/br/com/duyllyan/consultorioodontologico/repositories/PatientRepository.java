package br.com.duyllyan.consultorioodontologico.repositories;

import br.com.duyllyan.consultorioodontologico.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE p.dentist.id = ?1")
    List<Patient> findByDentistId(Long id);
}
