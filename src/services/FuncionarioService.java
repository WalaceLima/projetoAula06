package services;

import entities.Dependente;
import entities.Funcionario;
import factories.ConnectionFactory;
import repositories.DependenteRepository;
import repositories.FuncionarioRepository;

public class FuncionarioService {

	// método para executar o cadastro do funcionário
	// serviço de dominio (regra de negócio)
	public void cadastrarFuncionario(Funcionario funcionario) throws Exception {

		// verificar se o funcionário possui dependentes
		// e se possui, são no máximo 3 dependentes
		if (funcionario.getDependentes() != null && funcionario.getDependentes().size() <= 3) {

			FuncionarioRepository funcionarioRepository = new FuncionarioRepository(ConnectionFactory.getConnection());
			DependenteRepository dependenteRepository = new DependenteRepository(ConnectionFactory.getConnection());

			// gravar o funcionário no banco de dados
			funcionarioRepository.create(funcionario);

			// percorrer os dependentes
			for (Dependente dependente : funcionario.getDependentes()) {

				dependente.setFuncionario(funcionario); // relacionando o dependente com o funcionario
				dependenteRepository.create(dependente); // gravar o dependente no banco de dados
			}

		} else {
			// gerar um erro (exceção)
			throw new Exception("Funcionário não pode ter mais de 3 dependentes!");
		}
	}

}
