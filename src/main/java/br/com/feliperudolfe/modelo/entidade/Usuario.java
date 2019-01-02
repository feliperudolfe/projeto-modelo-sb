package br.com.feliperudolfe.modelo.entidade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.feliperudolfe.comum.modelo.Entidade;

@Entity
@Table(name = "tb_usuarios")
public class Usuario extends Entidade<Long> implements UserDetails {

	/**
	 *
	 */
	private static final long serialVersionUID = -2291710629656187658L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "apelido", nullable = false, length = 30)
	private String apelido;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@JsonIgnore
	@Column(name = "senha", nullable = false, length = 20)
	private String senha;

	@Column(name = "imagem")
	private String imagem;

	@Transient
	private String base64;

	@Transient
	private String novaSenha;

	@Transient
	private String confirmarSenha;

	@Column(name = "ativo")
	private boolean ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "atual_acesso")
	private Date atualAcesso;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ultimo_acesso")
	private Date ultimoAcesso;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pessoa")
	private Pessoa pessoa;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Perfil perfil;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getAtualAcesso() {
		return atualAcesso;
	}

	public void setAtualAcesso(Date atualAcesso) {
		this.atualAcesso = atualAcesso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (this.perfil != null) ? this.perfil.getPermissoes() : new ArrayList<Permissao>();
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return Boolean.TRUE;
	}

	@Override
	public boolean isAccountNonLocked() {
		return Boolean.TRUE;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return Boolean.TRUE;
	}

	@Override
	public boolean isEnabled() {
		return this.ativo;
	}

}