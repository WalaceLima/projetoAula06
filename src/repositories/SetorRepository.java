package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Setor;
import interfaces.ISetorRepository;

public class SetorRepository implements ISetorRepository {

	private Connection connection;

	public SetorRepository(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public void create(Setor entity) throws Exception {

		String sql = "insert into setor(nome) values(?)";

		PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		statement.setString(1, entity.getNome());

		statement.execute();

		ResultSet result = statement.getGeneratedKeys();
		if (result.next())
			entity.setIdSetor(result.getInt(1)); // 1 posição

		statement.close();
	}

	@Override
	public void update(Setor entity) throws Exception {

		String sql = "update setor set nome = ? where idsetor = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, entity.getNome());
		statement.setInt(2, entity.getIdSetor());

		statement.execute();
		statement.close();
	}

	@Override
	public void delete(Setor entity) throws Exception {

		String sql = "delete from setor where idsetor = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, entity.getIdSetor());

		statement.execute();
		statement.close();

	}

	@Override
	public List<Setor> findAll() throws Exception {

		String sql = "select * from setor";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();

		List<Setor> lista = new ArrayList<Setor>();

		while (result.next()) {

			Setor setor = new Setor();

			setor.setIdSetor(result.getInt("idsetor"));
			setor.setNome(result.getString("nome"));

			lista.add(setor);
		}

		return lista;
	}

	@Override
	public Setor findById(Integer id) throws Exception {

		String sql = "select * from setor where idsetor = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet result = statement.executeQuery();

		if (result.next()) {

			Setor setor = new Setor();

			setor.setIdSetor(result.getInt("idsetor"));
			setor.setNome(result.getString("nome"));

			return setor;
		}

		return null;
	}

}
