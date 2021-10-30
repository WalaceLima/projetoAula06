package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Funcionario;
import interfaces.IFuncionarioRepository;

public class FuncionarioRepository implements IFuncionarioRepository {

	private Connection connection;

	public FuncionarioRepository(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public void create(Funcionario entity) throws Exception {

		String sql = "insert into funcionario(nome, cpf, matricula, idsetor) values(?,?,?,?)";

		PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		statement.setString(1, entity.getNome());
		statement.setString(2, entity.getCpf());
		statement.setString(3, entity.getMatricula());
		statement.setInt(4, entity.getSetor().getIdSetor());

		statement.execute();

		ResultSet result = statement.getGeneratedKeys();
		if (result.next())
			entity.setIdFuncionario(result.getInt(1)); // 1 posição

		statement.close();

	}

	@Override
	public void update(Funcionario entity) throws Exception {

		String sql = "update funcionario set nome = ?, cpf = ?, matricula = ?, idsetor = ? where idfuncionario = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, entity.getNome());
		statement.setString(2, entity.getCpf());
		statement.setString(3, entity.getMatricula());
		statement.setInt(4, entity.getSetor().getIdSetor());
		statement.setInt(5, entity.getIdFuncionario());

		statement.execute();
		statement.close();
	}

	@Override
	public void delete(Funcionario entity) throws Exception {

		String sql = "delete from funcionario where idfuncionario = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, entity.getIdFuncionario());

		statement.execute();
		statement.close();

	}

	@Override
	public List<Funcionario> findAll() throws Exception {

		String sql = "select * from funcionario";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();

		List<Funcionario> lista = new ArrayList<Funcionario>();

		while (result.next()) {

			Funcionario funcionario = new Funcionario();

			funcionario.setIdFuncionario(result.getInt("idfuncionario"));
			funcionario.setNome(result.getString("nome"));
			funcionario.setCpf(result.getString("cpf"));
			funcionario.setMatricula(result.getString("matricula"));

			lista.add(funcionario);
		}

		return lista;
	}

	@Override
	public Funcionario findById(Integer id) throws Exception {

		String sql = "select * from funcionario where idfuncionario = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet result = statement.executeQuery();

		if (result.next()) {

			Funcionario funcionario = new Funcionario();

			funcionario.setIdFuncionario(result.getInt("idfuncionario"));
			funcionario.setNome(result.getString("nome"));
			funcionario.setCpf(result.getString("cpf"));
			funcionario.setMatricula(result.getString("matricula"));

			return funcionario;
		}

		return null;
	}

}
