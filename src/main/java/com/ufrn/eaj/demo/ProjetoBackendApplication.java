package com.ufrn.eaj.demo;

import com.ufrn.eaj.demo.domain.*;
import com.ufrn.eaj.demo.domain.enums.EstadoPagamento;
import com.ufrn.eaj.demo.domain.enums.TipoCliente;
import com.ufrn.eaj.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.rmi.runtime.NewThreadAction;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class ProjetoBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(ProjetoBackendApplication.class, args);
    }

    @Override
    public void run(String... args)throws Exception{

    }


}
