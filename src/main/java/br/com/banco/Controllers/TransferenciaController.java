package br.com.banco.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.Model.Transferencia;
import br.com.banco.Repository.TransferenciaRepository;

@RestController
public class TransferenciaController {
    
    @Autowired
    private TransferenciaRepository TransferenciaRepository;

    @RequestMapping("/Transferencias")
    public Iterable<Transferencia> Contas(){
        return TransferenciaRepository.findAll();
    }

    @RequestMapping("/Transferencias/{conta_id}")
    public Iterable<Transferencia> ContasCliente(int conta_id){
        return TransferenciaRepository.findBycontaidEquals(conta_id);
    }
}
