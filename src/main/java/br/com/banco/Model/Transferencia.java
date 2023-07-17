package br.com.banco.Model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data   
@Entity
public class Transferencia {

    @Id
    private int id; 
    
    @Column (name = "data_transferencia", nullable = false)
    private java.sql.Timestamp dataTransferencia;
    
    @Column(precision=10, scale=2)
    private BigDecimal valor;
    
    @Column
    private String tipo;
    
    @Column(name = "nome_operador_transacao")
    private String nomeOperadorTransacao;

    @Column(name = "conta_id", nullable = false)
    private int contaid;
}
