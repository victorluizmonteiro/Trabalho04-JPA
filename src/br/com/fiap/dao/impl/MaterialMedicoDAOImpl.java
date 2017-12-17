package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.MaterialMedicoDAO;
import br.com.fiap.entity.MaterialMedico;

public class MaterialMedicoDAOImpl  extends GenericDAOImpl<MaterialMedico, Integer> implements MaterialMedicoDAO{

	public MaterialMedicoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<MaterialMedico> list() {
		TypedQuery<MaterialMedico> query = em.createQuery("from MaterialMedico m",MaterialMedico.class);
		return query.getResultList();
	}

	@Override
	public List<MaterialMedico> findMateriaisByIdPaciente(int idPaciente) {
		TypedQuery<MaterialMedico>q = em.createQuery("from MaterialMedico m where m.paciente.cpf =:idPaciente",MaterialMedico.class);
		q.setParameter("idPaciente", idPaciente);
		return q.getResultList();
	}

}
