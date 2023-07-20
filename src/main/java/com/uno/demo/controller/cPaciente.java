package com.uno.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.uno.demo.entities.Paciente;
import com.uno.demo.services.sPaciente;

public class cPaciente {
    
    @GetMapping("/paciente")
    public ResponseEntity<Paciente> getPacientes() {
        List<Paciente> pacientes = sPaciente.findAll()
                .orElseThrow(() -> new ProductNotFoundException(id));

        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    @PostMapping("/paciente")
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        Paciente unpa = productService.createPaciente(paciente);
        return new ResponseEntity<>(unpa, HttpStatus.CREATED);
    }

    @PutMapping("/paciente/{id}")
    public ResponseEntity<Product> modifyProduct(@PathVariable long id, @RequestBody Product newProduct) {
        Product product = productService.modifyProduct(id, newProduct);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<Response> deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }
}
