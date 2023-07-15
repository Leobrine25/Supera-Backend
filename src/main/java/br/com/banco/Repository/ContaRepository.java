package br.com.banco.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.banco.Model.Conta;

public interface ContaRepository extends CrudRepository<Conta, Integer> {
}
