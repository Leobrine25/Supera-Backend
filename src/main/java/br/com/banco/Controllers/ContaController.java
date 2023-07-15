package br.com.banco.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.Model.Conta;
import br.com.banco.Repository.ContaRepository;

@RestController
public class ContaController {
    
    @Autowired
    private ContaRepository ContaRepository;


    @RequestMapping("/Contas")
    public Iterable<Conta> Contas(){
        return ContaRepository.findAll();
    }
}
