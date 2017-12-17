package br.com.fiap.main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AgendaDAO;
import br.com.fiap.dao.MaterialMedicoDAO;
import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.dao.ProcedimentoDAO;
import br.com.fiap.dao.impl.AgendaDAOImpl;
import br.com.fiap.dao.impl.MaterialMedicoDAOImpl;
import br.com.fiap.dao.impl.PacienteDAOImpl;
import br.com.fiap.dao.impl.ProcedimentoDAOImpl;
import br.com.fiap.entity.Agenda;
import br.com.fiap.entity.MaterialMedico;
import br.com.fiap.entity.Paciente;
import br.com.fiap.entity.Procedimento;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Aplicacao {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		PacienteDAO pacienteDao = new PacienteDAOImpl(em);
		AgendaDAO agendaDao = new AgendaDAOImpl(em);
		ProcedimentoDAO procedimentoDAO = new ProcedimentoDAOImpl(em);
		MaterialMedicoDAO materialDAO = new MaterialMedicoDAOImpl(em);
		
		Agenda a1 = new Agenda();
		a1.setData(LocalDate.now());
		a1.setHora(LocalTime.now());
		a1.setDescricao("Agenda 1");
		
		
		//Criando lista de agendas
		List<Agenda>agendas = new ArrayList<Agenda>();
		agendas.add(a1);
		
		Procedimento p1 = new Procedimento();
		p1.setDescricao("Procedimento 1");
		p1.setPreco(100.0);
		
		Procedimento p2 = new Procedimento();
		p2.setDescricao("Procedimento 2");
		p2.setPreco(200.0);
		
		MaterialMedico m1 = new MaterialMedico();
		m1.setDescricao("Material 1");
		m1.setFabricante("Fabricante 1");
		m1.setValor(5000.0);
		
		MaterialMedico m2 = new MaterialMedico();
		m2.setDescricao("Material 2");
		m2.setFabricante("Fabricante 2");
		m2.setValor(5000.0);
		
		Paciente paciente1 = new Paciente();
		paciente1.setCpf(484748);
		paciente1.setDataNascimento(LocalDate.now());
		paciente1.setNome("Victor Monteiro");
		paciente1.setTelefone("4183-9883");
		List<Paciente>pacientes = new ArrayList<Paciente>();
		pacientes.add(paciente1);
		
		paciente1.addMateriais(m1);
		paciente1.addMateriais(m2);
		
		paciente1.addProcedimentos(p1);
		paciente1.addProcedimentos(p2);
		
		
		a1.setPacientes(pacientes);
		paciente1.setAgendas(agendas);
		
		agendaDao.insert(a1);
		pacienteDao.insert(paciente1);
		
		
		List<Procedimento> procedimentos = procedimentoDAO.findProcedimentosByIdPaciente(paciente1.getCpf());
		List<MaterialMedico> materiais = materialDAO.findMateriaisByIdPaciente(paciente1.getCpf());
		
		procedimentos.forEach(System.out::println);
		materiais.forEach(System.out::println);
		
	

		
		
		
		
		
			

	}

}
