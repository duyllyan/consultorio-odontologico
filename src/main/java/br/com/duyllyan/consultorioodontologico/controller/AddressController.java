package br.com.duyllyan.consultorioodontologico.controller;

import br.com.duyllyan.consultorioodontologico.dto.AddressDTO;
import br.com.duyllyan.consultorioodontologico.dto.PatientDTO;
import br.com.duyllyan.consultorioodontologico.services.AddressService;
import br.com.duyllyan.consultorioodontologico.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService service;

    @PostMapping
    public ResponseEntity<AddressDTO> save (@RequestBody AddressDTO address) {
        AddressDTO addressDTO = service.save(address);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addressDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(addressDTO);
    }
}
