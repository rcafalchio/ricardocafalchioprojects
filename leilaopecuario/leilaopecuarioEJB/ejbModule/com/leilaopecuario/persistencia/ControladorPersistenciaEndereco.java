package com.leilaopecuario.persistencia;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.leilaopecuario.entidades.Estado;

@Stateless
public class ControladorPersistenciaEndereco implements
		ControladorPersistenciaEnderecoLocal {

	private final static Logger LOGGER = Logger
			.getLogger(ControladorPersistenciaEndereco.class);

	@PersistenceContext(name = "leilao")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> recuperaListaEstados() {

		List<Estado> listaEstados = null;

		try {
			final String queryString = "SELECT e FROM Estado e "
					+ "order by e.uf";
			Query query = entityManager.createQuery(queryString);
			listaEstados = query.getResultList();
		} catch (Exception e) {
			LOGGER.error("Ocorreu um problema no m�todo recuperaListaEstados",
					e);
		}
		return listaEstados;
	}

}
