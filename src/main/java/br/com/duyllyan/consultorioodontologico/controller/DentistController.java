package br.com.duyllyan.consultorioodontologico.controller;

import br.com.duyllyan.consultorioodontologico.dto.DentistDTO;
import br.com.duyllyan.consultorioodontologico.services.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/dentists")
public class DentistController {

    @Autowired
    private DentistService service;

    @GetMapping
    public ResponseEntity<List<DentistDTO>> findAll() {
        List<DentistDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistDTO> findById(@PathVariable Long id) {
        DentistDTO dentist = service.findById(id);
        return ResponseEntity.ok().body(dentist);
    }

    @PostMapping
    public ResponseEntity<DentistDTO> save (@RequestBody DentistDTO patient) {
        DentistDTO dentistDTO = service.save(patient);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dentistDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(dentistDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DentistDTO> update (@PathVariable Long id, @RequestBody DentistDTO patient) {
        DentistDTO dentistDTO = service.update(id, patient);
        return ResponseEntity.ok().body(dentistDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
