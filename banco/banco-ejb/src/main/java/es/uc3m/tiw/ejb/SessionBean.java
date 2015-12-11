package es.uc3m.tiw.ejb;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import es.uc3m.tiw.model.Pedido;
import es.uc3m.tiw.model.daos.ConciliacionEmpresaDAO;
import es.uc3m.tiw.model.daos.ConciliacionProfesorDAO;
import es.uc3m.tiw.model.daos.PedidoDAO;
import es.uc3m.tiw.model.ConciliacionProfesor;
import es.uc3m.tiw.model.ConciliacionEmpresa;

/**
 * Session Bean implementation class SessionBean
 */
@Stateless(name="pedidos")
@LocalBean
public class SessionBean implements SessionBeanLocal {

	@PersistenceContext(unitName = "banco-model")
	private EntityManager em;
	private PedidoDAO daoPedido;
	private ConciliacionProfesorDAO daoCP;
	private ConciliacionEmpresaDAO daoCE;
	
  
    public SessionBean() {
        
    }
    
    public String pagoNormal
    (String numeroTarjeta, String codigoPedido, double importe){
		
    	
    	daoPedido = new PedidoDAO(em);

		numeroTarjeta = numeroTarjeta.toUpperCase();
		Date fecha = new Date();
		String codigoOperacion = "BANCO"
				+ new SimpleDateFormat("yyyyMMddhhssSSSSa").format(fecha);
		System.out.print(codigoOperacion);

		if (importe > 0 && codigoPedido.length() != 0
				&& numeroTarjeta.matches("[A|B]+\\w{19}")) {

			Pedido pedido = new Pedido(codigoPedido, numeroTarjeta, importe,
					codigoOperacion);

			try {
				daoPedido.guardarPedido(pedido);
			} catch (SecurityException | IllegalStateException
					| RollbackException | HeuristicMixedException
					| HeuristicRollbackException | SystemException
					| NotSupportedException e) {
		
				e.printStackTrace();
			}

			return codigoOperacion;
		}
		return "";
    	
    }
    
    
    
    public String conciliacionProfesor(int mes,int anyo,double importe,long idProfesor){
    	
    	ConciliacionProfesor conciliacionProfesor = new ConciliacionProfesor(
				mes, anyo, importe, idProfesor);

		{
			try {
				daoCP.guardarConciliacionProfesor(conciliacionProfesor);
			} catch (SecurityException | IllegalStateException
					| RollbackException | HeuristicMixedException
					| HeuristicRollbackException | SystemException
					| NotSupportedException e) {

				e.printStackTrace();
			}
			return "ok";
		}
    }
    
    
    public String conciliacionEmpresa(int anyo,int mes,double importe){
    	
    	ConciliacionEmpresa conciliacionEmpresa = new ConciliacionEmpresa(
				mes, anyo, (importe * 0.99));

		 {
			try {
				daoCE.guardarConciliacionEmpresa(conciliacionEmpresa);
			} catch (SecurityException | IllegalStateException
					| RollbackException | HeuristicMixedException
					| HeuristicRollbackException | SystemException
					| NotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "ok";
		}
	}
    	
    }
    
    
    
    
