package es.uc3m.tiw.model.daos;

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
		// TODO Auto-generated constructor stub
	}
	//@Override
	public Pedido guardarPedido(Pedido pedido) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException{
		
		ut.begin();
		em.persist(pedido);
		ut.commit();
		return pedido;
	}
	//@Override
	public Pedido buscarPedido(Long codigoPedido){
		return em.find(Pedido.class, codigoPedido);
	}
	@Override
	public void Pedido(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
