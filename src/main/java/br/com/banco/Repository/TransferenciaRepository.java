package br.com.banco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.Model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {
    Iterable<Transferencia> findBycontaidEquals(int conta_id);
}
