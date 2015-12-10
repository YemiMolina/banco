package es.uc3m.tiw.model.daos;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.ConciliacionEmpresa;


public class ConciliacionEmpresaDAO {

	EntityManager em;
	UserTransaction ut;

	public ConciliacionEmpresaDAO(EntityManager em, UserTransaction ut){
		
		this.em=em;
		this.ut= ut;
		
	}

	//@Override
	public ConciliacionEmpresa guardarConciliacionEmpresa(ConciliacionEmpresa conciliacionEmpresa) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException{
		
		ut.begin();
		em.persist(conciliacionEmpresa);
		ut.commit();
		return conciliacionEmpresa;
	}
	
	
}
