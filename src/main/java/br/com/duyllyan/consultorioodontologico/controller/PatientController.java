package br.com.duyllyan.consultorioodontologico.controller;

import br.com.duyllyan.consultorioodontologico.dto.PatientDTO;
import br.com.duyllyan.consultorioodontologico.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> findAll() {
        List<PatientDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable Long id) {
        PatientDTO patient = service.findById(id);
        return ResponseEntity.ok().body(patient);
    }

    @GetMapping("/dentists/{id}")
    public ResponseEntity<List<PatientDTO>> findByDentistId(@PathVariable Long id) {
        List<PatientDTO> patients = service.findByDentistId(id);
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping
    public ResponseEntity<PatientDTO> save (@RequestBody PatientDTO patient) {
        PatientDTO patientDTO = service.save(patient);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(patientDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(patientDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatientDTO> update (@PathVariable Long id, @RequestBody PatientDTO patient) {
        PatientDTO patientDTO = service.update(id, patient);
        return ResponseEntity.ok().body(patientDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
