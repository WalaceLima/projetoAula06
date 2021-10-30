package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Dependente;
import helpers.DateTimeHelper;
import interfaces.IDependenteRepository;

public class DependenteRepository implements IDependenteRepository {

	private Connection connection;

	public DependenteRepository(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public void create(Dependente entity) throws Exception {

		String sql = "insert into dependente(nome, datanascimento, idfuncionario) values(?,?,?)";

		PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		statement.setString(1, entity.getNome());
		statement.setString(2, DateTimeHelper.formatDate(entity.getDataNascimento()));
		statement.setInt(3, entity.getFuncionario().getIdFuncionario());

		statement.execute();

		ResultSet result = statement.getGeneratedKeys();
		if (result.next())
			entity.setIdDependente(result.getInt(1)); // 1 posição

		statement.close();
	}

	@Override
	public void update(Dependente entity) throws Exception {

		String sql = "update dependente set nome = ?, datanascimento = ?, idfuncionario = ? where iddependente = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, entity.getNome());
		statement.setString(2, DateTimeHelper.formatDate(entity.getDataNascimento()));
		statement.setInt(3, entity.getFuncionario().getIdFuncionario());
		statement.setInt(4, entity.getIdDependente());

		statement.execute();
		statement.close();
	}

	@Override
	public void delete(Dependente entity) throws Exception {

		String sql = "delete from dependente where iddependente = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, entity.getIdDependente());

		statement.execute();
		statement.close();
	}

	@Override
	public List<Dependente> findAll() throws Exception {

		String sql = "select * from dependente";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();

		List<Dependente> lista = new ArrayList<Dependente>();

		while (result.next()) {

			Dependente dependente = new Dependente();

			dependente.setIdDependente(result.getInt("iddependente"));
			dependente.setNome(result.getString("nome"));
			dependente.setDataNascimento(result.getDate("datanascimento"));

			lista.add(dependente);
		}

		return lista;
	}

	@Override
	public Dependente findById(Integer id) throws Exception {

		String sql = "select * from dependente where iddependente = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet result = statement.executeQuery();

		if (result.next()) {

			Dependente dependente = new Dependente();

			dependente.setIdDependente(result.getInt("iddependente"));
			dependente.setNome(result.getString("nome"));
			dependente.setDataNascimento(result.getDate("datanascimento"));

			return dependente;
		}

		return null;
	}

}
