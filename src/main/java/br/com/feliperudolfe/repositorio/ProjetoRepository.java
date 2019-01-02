package br.com.feliperudolfe.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.feliperudolfe.modelo.entidade.Pessoa;
import br.com.feliperudolfe.modelo.entidade.Projeto;

/**
 * @Autor 		Felipe Rudolfe Carvalho Pinheiro
 * @Data		26 de dez de 2018 às 21:06:57
 */
@Repository
public interface ProjetoRepository extends JpaRepository<Pessoa, Long> {

	static final String BUSCAR_POR_USUARIO = "SELECT c.codigo.projeto FROM Colaborador c WHERE c.codigo.usuario.codigo = :usuario";

	@Query(value = BUSCAR_POR_USUARIO)
	public List<Projeto> buscarProjetosPorUsuario(@Param("usuario") Long usuario);

}