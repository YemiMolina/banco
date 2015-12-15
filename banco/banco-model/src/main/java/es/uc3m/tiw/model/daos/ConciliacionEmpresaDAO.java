package es.uc3m.tiw.model.daos;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import es.uc3m.tiw.model.ConciliacionEmpresa;

public class ConciliacionEmpresaDAO {

	EntityManager em;

	public ConciliacionEmpresaDAO(EntityManager em) {

		this.em = em;

	}

	public ConciliacionEmpresa guardarConciliacionEmpresa(
			ConciliacionEmpresa conciliacionEmpresa) throws SecurityException,
			IllegalStateException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SystemException, NotSupportedException {

		em.persist(conciliacionEmpresa);

		return conciliacionEmpresa;
	}

}
