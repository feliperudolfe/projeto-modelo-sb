package br.com.feliperudolfe.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.feliperudolfe.modelo.entidade.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	static final String BUSCAR_POR_EMAIL = "SELECT u FROM Usuario u WHERE u.email = :email";
	static final String BUSCAR_POR_EMAIL_E_SENHA = "SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha";

	@Query(BUSCAR_POR_EMAIL)
	Usuario buscarUsuarioPorEmail(@Param("email") String email);

	@Query(BUSCAR_POR_EMAIL_E_SENHA)
	Usuario buscarUsuarioPorEmailESenha(@Param("email") String email, @Param("senha") String senha);

}