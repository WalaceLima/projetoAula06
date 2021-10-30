package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import entities.Dependente;
import entities.Funcionario;
import entities.Setor;
import services.FuncionarioService;

public class Principal {

	public static void main(String[] args) {

		try {

			Funcionario funcionario = new Funcionario();
			funcionario.setSetor(new Setor());
			funcionario.setDependentes(new ArrayList<Dependente>());

			funcionario.setNome("Sergio Mendes");
			funcionario.setCpf("123.456.789-00");
			funcionario.setMatricula("2021-001");
			funcionario.getSetor().setIdSetor(1);
			
			Dependente dependente1 = new Dependente();
			dependente1.setNome("Ana Paula");
			dependente1.setDataNascimento(new GregorianCalendar(2015, Calendar.JANUARY, 10).getTime());
			
			Dependente dependente2 = new Dependente();
			dependente2.setNome("João Pedro");
			dependente2.setDataNascimento(new GregorianCalendar(2010, Calendar.SEPTEMBER, 20).getTime());

			funcionario.getDependentes().add(dependente1);
			funcionario.getDependentes().add(dependente2);
			
			FuncionarioService service = new FuncionarioService();
			service.cadastrarFuncionario(funcionario);

			System.out.println("Funcionário cadastrado com sucesso.");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
