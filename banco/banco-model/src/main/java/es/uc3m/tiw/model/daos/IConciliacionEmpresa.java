package es.uc3m.tiw.model.daos;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import es.uc3m.tiw.model.ConciliacionEmpresa;


public interface IConciliacionEmpresa {

	
	public abstract ConciliacionEmpresa guardarConciliacionEmpresa(ConciliacionEmpresa conciliacionEmpresa)throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException;
	
	
}
