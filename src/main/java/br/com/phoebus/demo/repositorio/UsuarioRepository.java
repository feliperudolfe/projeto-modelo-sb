package br.com.phoebus.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.phoebus.demo.modelo.entidade.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	static final String BUSCAR_POR_LOGIN = "SELECT u FROM Usuario u WHERE u.login = :login";
	static final String BUSCAR_POR_LOGIN_E_SENHA = "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha";

	@Query(BUSCAR_POR_LOGIN)
	Usuario buscarUsuarioPorLogin(@Param("login") String login);

	@Query(BUSCAR_POR_LOGIN_E_SENHA)
	Usuario buscarUsuarioPorLoginESenha(@Param("login") String login, @Param("senha") String senha);

}