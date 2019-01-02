package br.com.feliperudolfe.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.feliperudolfe.modelo.entidade.Pessoa;

/**
 * @author 	felipe.rudolfe
 * @date	3 de dez de 2018 às 18:00:32
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}