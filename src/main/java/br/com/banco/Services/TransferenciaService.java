package br.com.banco.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.Model.Transferencia;
import br.com.banco.Repository.TransferenciaRepository;

@Service
public class TransferenciaService {
    @Autowired
    private TransferenciaRepository TransferenciaRepository;

    public Iterable<Transferencia> findBycontaidAndnomeOperadorTransacao(int conta_id,String NomeOperador){
        Iterable<Transferencia> Todos =TransferenciaRepository.findBycontaidEquals(conta_id);
        ArrayList<Transferencia> Filtrado = new ArrayList<>();
        Todos.forEach(singular->{
            String Nome = "";
            if(singular.getNomeOperadorTransacao() != null){
                Nome = singular.getNomeOperadorTransacao();
            }
            if(Nome.equals(NomeOperador)){
                Filtrado.add(singular);
            }
        });
        return Filtrado;
    }
    public Iterable<Transferencia> findByDate(int conta_id,java.sql.Timestamp ini , java.sql.Timestamp fim){
        Iterable<Transferencia> Todos =TransferenciaRepository.findBycontaidEquals(conta_id);
        ArrayList<Transferencia> Filtrado = new ArrayList<>();
        java.sql.Timestamp inicia = ini,fina = fim;
        Todos.forEach(singular->{
            java.sql.Timestamp Dia = null;
            if(singular.getDataTransferencia() != null){
                Dia = singular.getDataTransferencia();
                if(Dia.after(inicia) && Dia.before(fina)){
                    Filtrado.add(singular);
                }
            }
        });
        return Filtrado;
    }

    public Iterable<Transferencia> findEquals(Iterable<Transferencia> Iterable1, Iterable<Transferencia> Iterable2){
        
        ArrayList<Transferencia> Resultado = new ArrayList<>();
        Iterable1.forEach(Value1->{
            int id1 = Value1.getId();

            Iterable2.forEach(Value2->{
                int id2 = Value2.getId();

                if(id1 == id2){
                    Resultado.add(Value1);
                }
            });
        });

        return Resultado;
    }
}
