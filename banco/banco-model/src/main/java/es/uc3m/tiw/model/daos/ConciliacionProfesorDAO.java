package es.uc3m.tiw.model.daos;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.ConciliacionProfesor;


public class ConciliacionProfesorDAO {
	EntityManager em;
	//UserTransaction ut;

	public ConciliacionProfesorDAO(EntityManager em){
		
		this.em=em;
	//	this.ut= ut;
		
	}

	//@Override
	public ConciliacionProfesor guardarConciliacionProfesor(ConciliacionProfesor conciliacionProfesor) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException{
		
	//	ut.begin();
		em.persist(conciliacionProfesor);
	//	ut.commit();
		return conciliacionProfesor;
	}
}
