package com.ufrn.eaj.demo.services;

import com.ufrn.eaj.demo.domain.Cliente;
import com.ufrn.eaj.demo.repositories.ClienteRepository;
import com.ufrn.eaj.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id){
        Optional<Cliente>obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", tipo: " + Cliente.class.getName()));
    }
}
