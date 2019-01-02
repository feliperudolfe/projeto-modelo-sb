package br.com.feliperudolfe.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.feliperudolfe.modelo.entidade.Perfil;

/**
 * @Autor 		Felipe Rudolfe Carvalho Pinheiro
 * @Data		24 de dez de 2018 às 18:39:21
 */
@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}