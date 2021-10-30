package entities;

import java.util.Date;

public class Dependente {

	private Integer idDependente;
	private String nome;
	private Date dataNascimento;

	// Dependente pertence a 1 Funcionario (Associação)
	private Funcionario funcionario;

	public Dependente() {
		// TODO Auto-generated constructor stub
	}

	public Dependente(Integer idDependente, String nome, Date dataNascimento, Funcionario funcionario) {
		super();
		this.idDependente = idDependente;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.funcionario = funcionario;
	}

	public Integer getIdDependente() {
		return idDependente;
	}

	public void setIdDependente(Integer idDependente) {
		this.idDependente = idDependente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Dependente [idDependente=" + idDependente + ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+ ", funcionario=" + funcionario + "]";
	}

}
