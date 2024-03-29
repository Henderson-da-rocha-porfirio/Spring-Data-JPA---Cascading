package com.tuyo.associations;

import com.tuyo.associations.manytomany.entities.Programador;
import com.tuyo.associations.manytomany.entities.Projeto;
import com.tuyo.associations.manytomany.repos.ProgramadorRepository;
import com.tuyo.associations.onetomany.entities.Cliente;
import com.tuyo.associations.onetomany.entities.NumeroTelefone;
import com.tuyo.associations.onetomany.repos.ClienteRepository;
import com.tuyo.associations.onetoone.entities.Licenca;
import com.tuyo.associations.onetoone.entities.Pessoa;
import com.tuyo.associations.onetoone.repos.LicencaRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssociationsCascadeApplicationTests {

	@Autowired
	ClienteRepository repository;

	@Autowired
	ProgramadorRepository programmerRepository;

	@Autowired
	LicencaRepository licencaRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreateCliente() {

		Cliente cliente = new Cliente();
		cliente.setName("John");

		NumeroTelefone ph1 = new NumeroTelefone();
		ph1.setNumber("1234567890");
		ph1.setType("cell");

		NumeroTelefone ph2 = new NumeroTelefone();
		ph2.setNumber("0987654321");
		ph2.setType("home");

		cliente.addNumeroTelefone(ph1);
		cliente.addNumeroTelefone(ph2);

		repository.save(cliente);
	}

	@Test
	@Transactional
	public void testLoadCliente() {
		Cliente cliente = repository.findById(4L).get();
		System.out.println(cliente.getName());

		Set<NumeroTelefone> numbers = cliente.getNumbers();
		numbers.forEach(number -> System.out.println(number.getNumber()));

	}

	@Test
	public void testUpdateCliente() {
		Cliente cliente = repository.findById(4L).get();
		cliente.setName("John Bush");

		Set<NumeroTelefone> numbers = cliente.getNumbers();
		numbers.forEach(number -> number.setType("cell"));

		repository.save(cliente);

	}

	@Test
	public void testDelete() {
		repository.deleteById(4l);
	}

	@Test
	public void testmtomCreateProgramador() {
		Programador programador = new Programador();
		programador.setName("John");
		programador.setSal(10000);

		HashSet<Projeto> projetos = new HashSet<>();
		Projeto projeto = new Projeto();
		projeto.setName("Hibernate Projeto");
		projetos.add(projeto);

		programador.setProjetos(projetos);

		programmerRepository.save(programador);
	}

	@Test
	@Transactional
	public void testmtomFindProgramador() {
		Programador programador = programmerRepository.findById(1).get();
		System.out.println(programador);
		System.out.println(programador.getProjetos());
	}

	@Test
	public void testOneToOneCreateLicenca() {
		Licenca licenca = new Licenca();
		licenca.setType("CAR");
		licenca.setValidFrom(new Date());
		licenca.setValidTo(new Date());

		Pessoa pessoa = new Pessoa();
		pessoa.setFirstName("John");
		pessoa.setLastName("Clinton");
		pessoa.setAge(35);

		licenca.setPessoa(pessoa);

		licencaRepository.save(licenca);
	}

}
