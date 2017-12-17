package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.MaterialMedico;

public interface MaterialMedicoDAO extends GenericDAO<MaterialMedico, Integer> {
	List<MaterialMedico> list();
	
	List<MaterialMedico> findMateriaisByIdPaciente(int idPaciente);
}
