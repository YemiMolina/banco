package es.uc3m.tiw.model.daos;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Pedido;

public class PedidoDAO implements IPedido {

	EntityManager em;
	UserTransaction ut;

	public PedidoDAO(EntityManager em, UserTransaction ut){
		
		this.em=em;
		this.ut= ut;
		
	}

	public PedidoDAO(EntityManager em2) {
		em = em2;
	
	}


	public Pedido guardarPedido(Pedido pedido) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException{
		
		//ut.begin();
		
		em.persist(pedido);
		//ut.commit();
		return pedido;
	}

	public Pedido buscarPedido(Long codigoPedido){
		return em.find(Pedido.class, codigoPedido);
	}

	@Override
	public void Pedido(Long codigoPedido) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
}
