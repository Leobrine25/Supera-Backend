package br.com.banco.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.banco.Model.Transferencia;

public interface TransferenciaRepository extends CrudRepository<Transferencia, Integer> {
    Iterable<Transferencia> findBycontaidEquals(int conta_id);
}
