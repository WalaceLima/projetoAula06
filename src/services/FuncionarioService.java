package services;

import entities.Dependente;
import entities.Funcionario;
import factories.ConnectionFactory;
import repositories.DependenteRepository;
import repositories.FuncionarioRepository;

public class FuncionarioService {

	// m�todo para executar o cadastro do funcion�rio
	// servi�o de dominio (regra de neg�cio)
	public void cadastrarFuncionario(Funcionario funcionario) throws Exception {

		// verificar se o funcion�rio possui dependentes
		// e se possui, s�o no m�ximo 3 dependentes
		if (funcionario.getDependentes() != null && funcionario.getDependentes().size() <= 3) {

			FuncionarioRepository funcionarioRepository = new FuncionarioRepository(ConnectionFactory.getConnection());
			DependenteRepository dependenteRepository = new DependenteRepository(ConnectionFactory.getConnection());

			// gravar o funcion�rio no banco de dados
			funcionarioRepository.create(funcionario);

			// percorrer os dependentes
			for (Dependente dependente : funcionario.getDependentes()) {

				dependente.setFuncionario(funcionario); // relacionando o dependente com o funcionario
				dependenteRepository.create(dependente); // gravar o dependente no banco de dados
			}

		} else {
			// gerar um erro (exce��o)
			throw new Exception("Funcion�rio n�o pode ter mais de 3 dependentes!");
		}
	}

}
