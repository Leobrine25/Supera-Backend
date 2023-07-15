package br.com.banco.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Conta {

    @Id
    private int id_conta; 

    @Column
    private String nome_responsavel;

}
