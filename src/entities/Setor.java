package entities;

import java.util.List;

public class Setor {

	private Integer idSetor;
	private String nome;

	private List<Funcionario> funcionarios;

	public Setor() {
		// TODO Auto-generated constructor stub
	}

	public Setor(Integer idSetor, String nome, List<Funcionario> funcionarios) {
		super();
		this.idSetor = idSetor;
		this.nome = nome;
		this.funcionarios = funcionarios;
	}

	public Integer getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(Integer idSetor) {
		this.idSetor = idSetor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public String toString() {
		return "Setor [idSetor=" + idSetor + ", nome=" + nome + ", funcionarios=" + funcionarios + "]";
	}

}
