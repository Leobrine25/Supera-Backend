package br.com.banco.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data   
@Entity
public class Transferencia {

    @Id
    private int id; 
    
    @Column
    private java.sql.Timestamp data_transferencia;
    
    @Column
    private long valor;
    
    @Column
    private String tipo;
    
    @Column
    private String nome_operador_transacao;

    @Column(name = "conta_id", nullable = false)
    private Integer contaid;
}
