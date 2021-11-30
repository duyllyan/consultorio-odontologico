package br.com.duyllyan.consultorioodontologico.controller;

import br.com.duyllyan.consultorioodontologico.dto.PatientDTO;
import br.com.duyllyan.consultorioodontologico.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
