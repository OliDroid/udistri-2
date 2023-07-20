package com.uno.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uno.demo.entities.Paciente;
/*import com.example.myshop.exception.ProductNotFoundException;*/
import com.uno.demo.repositories.rCita;
import com.uno.demo.repositories.rPaciente;

import java.util.Optional;
import java.util.Set;

/**
 * Implementación del Service de productos
 * 
 * @author --
 * @version 1.0
 */
@Service
public class impPaciente implements sPaciente {

    @Autowired
    private rPaciente rpaciente;

    @Override
    public Set<Paciente> findAll() {
        return rpaciente.findAll();
    }


    @Override
    public Set<Paciente> findById(long id) {
        return rpaciente.findById(id);
    }

    @Override
    public Paciente addProduct(Paciente product) {
        return rpaciente.save(product);
    }

    @Override
    public Paciente modifyProduct(long id, Paciente newProduct) {
        Paciente product = rpaciente.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        newProduct.setId(product.getId());
        return rpaciente.save(newProduct);
    }

    @Override
    public void deleteProduct(long id) {
        rpaciente.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        rpaciente.deleteById(id);
    }
}