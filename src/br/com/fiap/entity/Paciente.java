package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Paciente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	
	private int cpf;
	private String nome;
	private LocalDate dataNascimento;
	private String telefone;
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="pacientes")
	private List<Agenda>agendas;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="paciente")
	private List<Procedimento>procedimentos;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="paciente")
	private List<MaterialMedico>materiais;

	public void addMateriais(MaterialMedico material) {
		materiais.add(material);
		material.setPaciente(this);
	}
	
	public void addProcedimentos(Procedimento procedimento) {
		
		procedimentos.add(procedimento);
		procedimento.setPaciente(this);
	}
	
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public List<MaterialMedico> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<MaterialMedico> materiais) {
		this.materiais = materiais;
	}

	public Paciente(int cpf, String nome, LocalDate dataNascimento, String telefone, List<Agenda> agendas,
			List<Procedimento> procedimentos, List<MaterialMedico> materiais) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.agendas = agendas;
		this.procedimentos = procedimentos;
		this.materiais = materiais;
	}

	public Paciente() {
		procedimentos = new ArrayList<Procedimento>();
		materiais = new ArrayList<MaterialMedico>();
	
	}
	
	
}
