package com.ufrn.eaj.demo.services;


import com.ufrn.eaj.demo.domain.Estado;
import com.ufrn.eaj.demo.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repo;

    public List<Estado>findAll(){
        return repo.findAllByOrderByNome();
    }
}
