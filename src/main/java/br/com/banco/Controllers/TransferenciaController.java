package br.com.banco.Controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.Model.Transferencia;
import br.com.banco.Repository.TransferenciaRepository;
import br.com.banco.Services.TransferenciaService;

@CrossOrigin
@RestController
@RequestMapping("/Transferencias")
public class TransferenciaController {
    
    @Autowired
    private TransferenciaRepository TransferenciaRepository;

    @Autowired
    private TransferenciaService TransferenciaService;
    
    @RequestMapping(value = "/{conta_id}/{Operador}",method=RequestMethod.GET)
    public Iterable<Transferencia> TransferenciaClientesOperador(@PathVariable int conta_id,@PathVariable String Operador){
        return TransferenciaService.findBycontaidAndnomeOperadorTransacao(conta_id , Operador);
    }
    
    @RequestMapping(value = "/{conta_id}/{ini}/{fim}",method=RequestMethod.GET)
    public Iterable<Transferencia> findByDate(@PathVariable int conta_id,
                                              @PathVariable String ini ,
                                              @PathVariable String fim) throws ParseException{

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Timestamp inicial = new java.sql.Timestamp ((dateFormat.parse(ini)).getTime());
        java.sql.Timestamp fina = new java.sql.Timestamp ((dateFormat.parse(fim)).getTime());
        return TransferenciaService.findByDate(conta_id , inicial, fina);
    }

    @RequestMapping(value = "/{conta_id}/{ini}/{fim}/{Operador}",method=RequestMethod.GET)
    public Iterable<Transferencia> findByDateAndOperador(@PathVariable int conta_id,
                                                        @PathVariable String ini ,  
                                                        @PathVariable String fim, 
                                                        @PathVariable String Operador) throws ParseException{

        Iterable<Transferencia> filtroOperador =TransferenciaService.findBycontaidAndnomeOperadorTransacao(conta_id , Operador);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Timestamp inicial = new java.sql.Timestamp ((dateFormat.parse(ini)).getTime());
        java.sql.Timestamp fina = new java.sql.Timestamp ((dateFormat.parse(fim)).getTime());

        Iterable<Transferencia> filtroData = TransferenciaService.findByDate(conta_id , inicial, fina);
        
        return TransferenciaService.findEquals(filtroOperador, filtroData);
    }

    @RequestMapping(value = "/{conta_id}",method=RequestMethod.GET)
    public Iterable<Transferencia> TransferenciaClientes(@PathVariable int conta_id){
        return TransferenciaRepository.findBycontaidEquals(conta_id);
    }

    @RequestMapping(method=RequestMethod.GET)
    public Iterable<Transferencia> Transferencias(){
        return TransferenciaRepository.findAll();
    }

}
